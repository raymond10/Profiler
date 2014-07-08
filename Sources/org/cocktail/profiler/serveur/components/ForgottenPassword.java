/*
 * Copyright COCKTAIL (www.cocktail.org), 1995, 2011 This software
 * is governed by the CeCILL license under French law and abiding by the
 * rules of distribution of free software. You can use, modify and/or
 * redistribute the software under the terms of the CeCILL license as
 * circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * As a counterpart to the access to the source code and rights to copy, modify
 * and redistribute granted by the license, users are provided only with a
 * limited warranty and the software's author, the holder of the economic
 * rights, and the successive licensors have only limited liability. In this
 * respect, the user's attention is drawn to the risks associated with loading,
 * using, modifying and/or developing or reproducing the software by the user
 * in light of its specific status of free software, that may mean that it
 * is complicated to manipulate, and that also therefore means that it is
 * reserved for developers and experienced professionals having in-depth
 * computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling
 * the security of their systems and/or data to be ensured and, more generally,
 * to use and operate it in the same conditions as regards security. The
 * fact that you are presently reading this means that you have had knowledge
 * of the CeCILL license and that you accept its terms.
 */
package org.cocktail.profiler.serveur.components;

import org.cocktail.fwkcktldroitsutils.common.util.MyStringCtrl;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompteEmail;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartPersonneAdresse;
import org.cocktail.fwkcktlpersonne.common.metier.EOVlans;
import org.cocktail.fwkcktlpersonne.server.finder.PersonneFinder;
import org.cocktail.fwkcktlwebapp.common.database.CktlUserInfoDB;
import org.cocktail.fwkcktlwebapp.server.CktlMailBus;
import org.cocktail.fwkcktlwebapp.server.CktlWebApplication;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.UtilMessages;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORedirect;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.ajax.AjaxModalDialog;

public class ForgottenPassword extends ProfilBaseCmp {
	private static final long serialVersionUID = 1L;
	
	private static final String PASSWORD_RECOVERY_INFORMATION_KEY = "PASSWORD_RECOVERY_INFORMATION";
	private static final String DEFAULT_PASSWORD_RECOVERY_INFORMATION = "Le service informatique ne peut vous communiquer de nouveau mot de passe sans avoir vérifié votre identité.";

	public ForgottenPassword(WOContext context) {
		super(context);
	}

	private String searchLogin;
	private EOCompte cptEdited;

	/**
	 * @return the searchLogin
	 */
	public String searchLogin() {
		return searchLogin;
	}

	/**
	 * @param searchLogin
	 *            the searchLogin to set
	 */
	public void setSearchLogin(String searchLogin) {
		this.searchLogin = searchLogin;
	}

	public WOActionResults valide() {
		if ((searchLogin == null) || ("".equals(searchLogin))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Le login est obligatoire !!");

			return null;
		}
		// recup du compte
		cptEdited = EOCompte.fetchByKeyValue(getEc(), EOCompte.CPT_LOGIN_KEY, searchLogin);
		if (cptEdited == null) {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Il n'existe aucun compte ayant comme login : "
							+ searchLogin + " !!");

			return null;
		}
		((Session) session()).setSelectedPersonne(PersonneFinder
				.fetchPersonneForLogin(getEc(), searchLogin));
		((Session) session())
				.setSelectedCompte(org.cocktail.fwkcktlpersonne.common.metier.EOCompte
						.fetchByKeyValue(
								getEc(),
								org.cocktail.fwkcktlpersonne.common.metier.EOCompte.CPT_LOGIN_KEY,
								searchLogin));
		lstMailsDispo = null;
		mailPro = null;

		return null;
	}

	public EOCompte getCptEdited() {
		return cptEdited;
	}

	public void setCptEdited(EOCompte cptEdited) {
		this.cptEdited = cptEdited;
	}

	private Boolean canSendPassword;
	private NSMutableArray<String> lstMailsDispo;

	/**
	 * @return the canSendPassword
	 */
	public Boolean canSendPassword() {
//		if (canSendPassword == null) {
//			// verif si le pass clair est dispo
//			if ((cptEdited != null) && (cptEdited.cptPasswdClair() != null)
//					&& (!"".equals(cptEdited.cptPasswdClair()))) {
//				// fetch d'adresses mails ou envoyer le pass
//				if (getLstMailsDispo().size() > 0)
//					canSendPassword = Boolean.TRUE;
//				else
//					canSendPassword = Boolean.FALSE;
//			} else
//				canSendPassword = Boolean.FALSE;
//
//		}
//		return canSendPassword;
		return  Boolean.FALSE;
	}

	/**
	 * @param canSendPassword
	 *            the canSendPassword to set
	 */
	public void setCanSendPassword(Boolean canSendPassword) {
		this.canSendPassword = canSendPassword;
	}

	public NSMutableArray<String> getLstMailsDispo() {
		if (lstMailsDispo == null) {
			lstMailsDispo = new NSMutableArray<String>();
			for (Object repart : ((Session) session()).selectedPersonne()
					.toRepartPersonneAdresses()) {
				if ((((EORepartPersonneAdresse) repart).eMail() != null)
						&& (!"".equals(((EORepartPersonneAdresse) repart)
								.eMail()))) {
					lstMailsDispo.add(((EORepartPersonneAdresse) repart)
							.eMail());
				}
			}
			for (Object cpt : ((Session) session()).selectedPersonne()
					.toComptes(null)) {
				if (!((org.cocktail.fwkcktlpersonne.common.metier.EOCompte) cpt)
						.cptLogin().equals(cptEdited.cptLogin())) {
					// c'est pas le meme compte que celui recherche
					for (Object cptEmailObj : ((org.cocktail.fwkcktlpersonne.common.metier.EOCompte) cpt)
							.toCompteEmails()) {
						EOCompteEmail cptEmail = (EOCompteEmail) cptEmailObj;
						if (cptEmail.getEmailFormatte() != null)
							lstMailsDispo.add(cptEmail.getEmailFormatte());
					}

				}

			}
		}

		return lstMailsDispo;
	}

	public void setLstMailsDispo(NSMutableArray<String> lstMailsDispo) {
		this.lstMailsDispo = lstMailsDispo;
	}

	public WOActionResults backToLogin() {
		setLstMailsDispo(null);
		setCanSendPassword(null);
		setCptEdited(null);
		return null;
	}

	private String mailToSend;

	/**
	 * @return the mailToSend
	 */
	public String mailToSend() {
		return mailToSend;
	}

	/**
	 * @param mailToSend
	 *            the mailToSend to set
	 */
	public void setMailToSend(String mailToSend) {
		this.mailToSend = mailToSend;
	}

	public WOActionResults sendMail() {
		CktlMailBus mailBus = new CktlMailBus(((Application) application())
				.config());
		String msg = "Bonjour,\n Voici le mot de passe de votre compte :\nLogin :  "
				+ cptEdited.cptLogin()
				+ "\nMot de passe : "
				+ cptEdited.cptPasswdClair() + "\n\n";
		if (mailBus.sendMail(cptEdited.toCompteEmail().cemEmail() + "@"
				+ cptEdited.toCompteEmail().cemDomaine(), mailToSend(), null,
				"Votre mot de passe", msg)) {
//		if (mailBus.sendMail(cptEdited.cptEmail() + "@"
//				+ cptEdited.cptDomaine(), mailToSend(), null,
//				"Votre mot de passe", msg)) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Message envoyé à l'adresse :\n " + mailToSend() + " !!");
		} else {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Erreur lors de l'envoie du message :\n "
							+ mailBus.getErrorMessage() + " !!");
		}
		return null;
	}

	private String reponse;

	/**
	 * @return the reponse
	 */
	public String reponse() {
		return reponse;
	}

	/**
	 * @param reponse
	 *            the reponse to set
	 */
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	private boolean loginOk = false;

	public WOActionResults valideQuestion() {
		loginOk = false;
		if ((reponse == null) || ("".equals(reponse))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Veuillez saisir une réponse !!");

			return null;
		}

		if ((cptEdited.cptReponse() == null)
				|| ("".equals(cptEdited.cptReponse()))) {
			UtilMessages
					.creatMessageUtil(
							session(),
							UtilMessages.ERROR_MESSAGE,
							"La réponse n'est pas renseignée pour ce compte, impossible de vous connecter !!");

			return null;
		}

		if (reponse.equals(cptEdited.cptReponse())) {
			loginOk = true;
			return null;
		} else
			UtilMessages
					.creatMessageUtil(session(), UtilMessages.ERROR_MESSAGE,
							"La réponse est incorrecte, impossible de vous connecter !!");

		return null;
	}

	public boolean isLoginOk() {
		return loginOk;
	}

	public WOActionResults connect() {
		((Session) session()).setSelectedOnglet(InfosCompte.class.getName());

		CktlUserInfoDB user = new CktlUserInfoDB(
				((CktlWebApplication) application()).dataBus());
		user.compteForPersId(cptEdited.persId(), false);

		NSMutableDictionary<String, Object> params = new NSMutableDictionary<String, Object>();
		params.setObjectForKey(user.login(), "netid");
//		params.setObjectForKey(InfosCompte.class.getName(), "selectedOnglet");
		String url = context().directActionURLForActionNamed("loginResult",
				params);
		WORedirect redirect = new WORedirect(context());
		redirect.setUrl(url);
		return redirect;
	}

	public WOActionResults initQuestion() {
		loginOk = false;
		return null;
	}

	public String mailDtSam() {
		return ((Application) application()).config().stringForKey(
				"MAIL_DT_SAM");
	}

	private boolean mailSended = false;

	public boolean isMailSended() {
		return mailSended;
	}

	public WOActionResults initMailDt() {
		mailSended = false;
		return null;
	}

	private String defaultMailSender;

	/**
	 * @return the defaultMailSender
	 */
	public String defaultMailSender() {
		if ((defaultMailSender == null) && (getLstMailsDispo() != null)
				&& (getLstMailsDispo().size() > 0))
			defaultMailSender = getLstMailsDispo().lastObject();
		return defaultMailSender;
	}

	/**
	 * @param defaultMailSender
	 *            the defaultMailSender to set
	 */
	public void setDefaultMailSender(String defaultMailSender) {
		this.defaultMailSender = defaultMailSender;
	}

	public String defaultMessageDT() {
		return "Perte du mot de passe du compte : Login = \"" + searchLogin
				+ "\"\n";

	}

	private String mailPro;

	/**
	 * Retourne un mail pro ou etudiant pour la personne 
	 * @return
	 */
	public String mailPro() {
		if (mailPro == null) {

			for (Object cpt : ((Session) session())
					.selectedPersonne()
					.toComptes(
							EOQualifier
									.qualifierWithQualifierFormat(
											"(("
													+ org.cocktail.fwkcktlpersonne.common.metier.EOCompte.TO_VLANS_KEY
													+ "."
													+ EOVlans.C_VLAN_KEY
													+ " = %s) OR ("
													+ org.cocktail.fwkcktlpersonne.common.metier.EOCompte.TO_VLANS_KEY
													+ "." + EOVlans.C_VLAN_KEY
													+ " = %s))",
											new NSArray<String>(new String[] {
													EOVlans.VLAN_P,
													EOVlans.VLAN_E })))) {
// TODO PYM : ajouter vlan R
				for (Object cptEmailObj : ((org.cocktail.fwkcktlpersonne.common.metier.EOCompte) cpt)
						.toCompteEmails()) {
					EOCompteEmail cptEmail = (EOCompteEmail) cptEmailObj;
					//System.out.println(cptEmail.getEmailFormatte());
					if (cptEmail.getEmailFormatte() != null) {
						mailPro = cptEmail.getEmailFormatte();
						break;
					}
				}
			}
		}

		return mailPro;
	}

	private String messageDT;

	/**
	 * @return the messageDT
	 */
	public String messageDT() {
		return messageDT;
	}

	/**
	 * @param messageDT
	 *            the messageDT to set
	 */
	public void setMessageDT(String messageDT) {
		this.messageDT = messageDT;
	}

	public WOActionResults envoieMailDT() {
		mailSended = false;
		if ((defaultMailSender == null) || ("".equals(defaultMailSender))) {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Veuillez saisir une adresse mail d'expéditeur !");
			AjaxModalDialog.update(context(), null); 
			return null;
		}

		CktlMailBus mailBus = new CktlMailBus(((Application) application())
				.config());
		String msg = defaultMessageDT() + messageDT();
		String cc = null;
		if ("O".equals(mailCopie))
			cc = defaultMailSender();
		if (!defaultMailSender.equals(mailPro()))
			msg += "\nMerci d'envoyer les réponses à l'adresse : "
					+ defaultMailSender;

//		if (mailBus.sendMail(mailPro(), mailDtSam(), cc, sujetMail(), msg)) {
		// Pro to DT
		if (mailBus.sendMail(mailPro(), mailDtSam(), null, sujetMail(), msg)) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Message envoyé !");
			// cc to Pro
			mailBus.sendMail(cc, mailPro(), null, sujetMail(), msg);
			if ("O".equals(mailCopie)) {
				// cc to cc
				mailBus.sendMail(cc, cc, null, sujetMail(), msg);
			}
		} else {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Erreur lors de l'envoie du message :\n "
							+ mailBus.getErrorMessage() + " !");
		}
		cancelEdit();
		mailSended = true;
		AjaxModalDialog.update(context(), null); 
		return null;
	}

	public String sujetMail() {
		return "Perte de mot de passe";
	}

	private String mailCopie;

	/**
	 * @return the mailCopie
	 */
	public String mailCopie() {
		return mailCopie;
	}

	/**
	 * @param mailCopie
	 *            the mailCopie to set
	 */
	public void setMailCopie(String mailCopie) {
		this.mailCopie = mailCopie;
	}

	public boolean canMakeDtMail() {
		return ((mailDtSam() != null) && (mailPro() != null));
	}

	public WOActionResults cancelMailDT() {
		messageDT = null;
		return null;
	}

	public String getSecurityInformation() {
		String securityInfoString = ((Application)application()).config().stringForKey(PASSWORD_RECOVERY_INFORMATION_KEY);
		
		if (MyStringCtrl.isEmpty(securityInfoString)) {
			securityInfoString = DEFAULT_PASSWORD_RECOVERY_INFORMATION;
		}
		return securityInfoString;
	}
}