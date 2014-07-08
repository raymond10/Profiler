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

package org.cocktail.profiler.serveur;

import org.cocktail.fwkcktlpersonne.common.metier.PersonneDelegate;
import org.cocktail.fwkcktlwebapp.common.CktlLog;
import org.cocktail.fwkcktlwebapp.common.CktlUserInfo;
import org.cocktail.fwkcktlwebapp.common.database.CktlUserInfoDB;
import org.cocktail.fwkcktlwebapp.common.util.StringCtrl;
import org.cocktail.fwkcktlwebapp.server.CktlWebAction;
import org.cocktail.fwkcktlwebapp.server.components.CktlAlertPage;
import org.cocktail.fwkcktlwebapp.server.components.CktlLogin;
import org.cocktail.fwkcktlwebapp.server.components.CktlLoginResponder;
import org.cocktail.fwkcktlwebapp.server.components.CktlWebPage;
import org.cocktail.profiler.serveur.components.InfosPerso;
import org.cocktail.profiler.serveur.components.Main;
import org.cocktail.profiler.serveur.components.MessagePage;
import org.cocktail.profiler.serveur.components.ProfilePage;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WORedirect;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSDictionary;

public class DirectAction extends CktlWebAction {
	public DirectAction(WORequest request) {
		super(request);
	}

	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}

	public WOActionResults profilAction() {
		ProfilePage next = (ProfilePage) pageWithName(ProfilePage.class
				.getName());

		return next;
	}
	
	 /**
     * Invalide le singleton syncref
     */
    public WOActionResults resetSyncRefFacadeAction() {
//            org.cocktail.fwksyncref.serveur.SyncRefFacade.invalidateInstance();
            return null;
    }

	public WOActionResults sessionPageAction() {
		WOComponent next = null;
		if (((Session) session()).getPageName() != null) {
			next = pageWithName(((Session) session()).getPageName());
			((Session) session()).setPageName(null);
		} else
			next = (ProfilePage) pageWithName(ProfilePage.class.getName());

		return next;
	}

	protected Session laSession() {
		Session cngSession = (Session) existingSession();
		if (cngSession == null) {
			cngSession = (Session) session();
		}
		return cngSession;
	}

	public WOActionResults loginResultAction() {

		Session sess = (Session) cktlApp.sessionStore().checkOutSessionWithID(
				(String) request().formValueForKey("amp;wosid"),
				context().request());
		// les 2 conditions ci-dessous font bogguer la méthode performActionName()
//		if (sess.getSelectedOnglet() != null) {
//			((Session) session()).setSelectedOnglet(sess.getSelectedOnglet());
//		}
//
//		if (sess.getSelectedCompte() != null) {
//			((Session) session()).setSelectedCompte(sess.getSelectedCompte());
//		}
		return loginCasSuccessPage(request().formValueForKey("netid")
				.toString());
	}

	/**
	 * CAS : traitement authentification OK
	 */
	public WOActionResults loginCasSuccessPage(String netid) {
		try {
			CktlUserInfoDB user = new CktlUserInfoDB(cktlApp.dataBus());

			user.compteForLogin(netid, null, true);
			//user.compteForLogin("u1.ambroise", null, true);
			if (user.errorCode() != CktlUserInfoDB.ERROR_NONE) {
				cktlSession().setObjectForKey(
						"Il y a eut un problème avec l'identification !",
						"MessageErreur");
			}

			// System.out.println("user" + user);
			cktlSession().setConnectedUserInfo(user);
			ProfilerUser gUser = new ProfilerUser(session()
					.defaultEditingContext(), (Integer) user.persId()
					.intValue(), cktlApp.config().stringForKey(
					"C_STRUCTURE_ADMIN"));
			boolean canUse = gUser.userCanUseAppli();
			CktlWebPage page = null;
			if (!canUse) {
				page = (CktlWebPage) pageWithName(MessagePage.class.getName());
				((MessagePage) page)
						.setMessage("Vous n'êtes pas autorisé(e) à  utiliser cette application !");
				((MessagePage) page).setShowMenu(false);
			} else {
				((Session) session()).setPUser(gUser);
				if (((Session) session()).getSelectedOnglet() == null)
					((Session) session()).setSelectedOnglet(InfosPerso.class
							.getName());
				((Session) session()).setSelectedPersonne(PersonneDelegate.fetchPersonneByPersId(session()
								.defaultEditingContext(), gUser.getPersId()));
				String url = context().directActionURLForActionNamed(
						"sessionPage", null);
				WORedirect redirect = new WORedirect(context());
				redirect.setUrl(url);
				return redirect;

			}

			return page;

		} catch (Exception e) {
			e.printStackTrace();
			return getErrorPage(e.getMessage());
		}
	}

	/**
	 * CAS : traitement authentification en echec
	 */
	public WOActionResults loginCasFailurePage(String errorMessage, String arg1) {
		WORequest request = context().request();
        String login = StringCtrl.normalize((String)request.formValueForKey("identifiant"));
		CktlLog.log("loginCasFailurePage : " + errorMessage + " (" + arg1 + ")");
		StringBuffer msg = new StringBuffer();
		String message = "Une erreur s'est produite lors de l'authentification de l'utilisateur " + login + "&nbsp;:<br><br>";
		msg.append(message);
		if (errorMessage != null)
			msg.append("&nbsp;:<br><br>").append(errorMessage);
		return getErrorPage(msg.toString());
	}

	/**
	 * CAS : page par defaut si CAS n'est pas parametre
	 */
	public WOActionResults loginNoCasPage() {
		return pageWithName(Main.class.getName());
	}

	/**
	 * affiche une page avec un message d'erreur
	 */
	private WOComponent getErrorPage(String errorMessage) {
		System.out.println("ERREUR = " + errorMessage);
		CktlAlertPage page = (CktlAlertPage) cktlApp.pageWithName(
				CktlAlertPage.class.getName(), context());
		page.showMessage(null, "ERREUR", errorMessage, null, null, null,
				CktlAlertPage.ERROR, null);
		return page;
	}

	/**
	 * Retourne la directAction attendue d'apres son nom <code>daName</code>. Si
	 * rien n'a ete trouve, alors une page d'avertissement est affichee.
	 */
	public WOActionResults performActionNamed(String aName) {
		WOActionResults result = null;
		try {
			result = super.performActionNamed(aName);
		} catch (Exception e) {
			result = getErrorPage("DirectAction introuvable : \"" + aName
					+ "\"");
		}
		return result;
	}

	public WOActionResults loginCasSuccessPage(String arg0, NSDictionary arg1) {
		return loginCasSuccessPage(arg0);
	}

	public WOActionResults loginNoCasPage(NSDictionary arg0) {
		return loginNoCasPage();
	}

	public WOActionResults validerLoginAction() {
	    Application app = (Application)WOApplication.application();
//	    if (!app.isDevelopmentMode())
	    if (useCasService()) {
	        throw new IllegalAccessError("Vous n'êtes pas autorisé à accéder à cette URL");
		}
        WOActionResults page = null;
        WORequest request = context().request();
        String login = StringCtrl.normalize((String)request.formValueForKey("identifiant"));
        String password = StringCtrl.normalize((String)request.formValueForKey("mot_de_passe"));
        String messageErreur = null;
        Session session = (Session)context().session();

        CktlLoginResponder loginResponder = getNewLoginResponder(null);
        CktlUserInfo loggedUserInfo = new CktlUserInfoDB(cktlApp.dataBus());
        if (login.length() == 0) {
            messageErreur = "Vous devez renseigner l'identifiant.";
        } else if (!loginResponder.acceptLoginName(login)) {
            messageErreur = "Vous n'ètes pas autorisé(e) à utiliser cette application";
        } else {
            if (password == null) password = "";
            loggedUserInfo.setRootPass(loginResponder.getRootPassword());
            loggedUserInfo.setAcceptEmptyPass(loginResponder.acceptEmptyPassword());
            loggedUserInfo.compteForLogin(login, password, true);
            if (loggedUserInfo.errorCode() != CktlUserInfo.ERROR_NONE) {
                if (loggedUserInfo.errorMessage() != null)
                    messageErreur = loggedUserInfo.errorMessage();
                CktlLog.rawLog(">> Erreur | "+loggedUserInfo.errorMessage());
            }
        }

        if (messageErreur == null) {
            session.setConnectedUserInfo(loggedUserInfo);
            String erreur = session.setConnectedUser(loggedUserInfo.login());
            if (erreur != null) {
                messageErreur = erreur;
            } else {
                ProfilerUser appUser = new ProfilerUser(session.defaultEditingContext(),Integer.valueOf(loggedUserInfo.persId().intValue()), cktlApp.config().stringForKey(
                "C_STRUCTURE_ADMIN"));
                boolean canUse = appUser.userCanUseAppli();
                if (!canUse) {
                    page = (CktlWebPage) pageWithName(MessagePage.class.getName());
                    ((MessagePage) page)
                            .setMessage("Vous n'êtes pas autorisé(e) à  utiliser cette application !");
                    ((MessagePage) page).setShowMenu(false);
                } else {
                    ((Session) session()).setPUser(appUser);
                    if (((Session) session()).getSelectedOnglet() == null)
                        ((Session) session()).setSelectedOnglet(InfosPerso.class
                                .getName());
                    ((Session) session()).setSelectedPersonne(PersonneDelegate.fetchPersonneByPersId(session()
                                    .defaultEditingContext(), appUser.getPersId()));
                    String url = context().directActionURLForActionNamed(
                            "sessionPage", null);
                    WORedirect redirect = new WORedirect(context());
                    redirect.setUrl(url);
                    return redirect;

                }
            }
        }

//        if (messageErreur != null) {
//            page = (Login)pageWithName(Login.class.getName());
//            ((Login)page).setMessageErreur(messageErreur);
//            return page;
//        }

        return loginResponder.loginAccepted(null);

    }
	
	 
    public CktlLoginResponder getNewLoginResponder(NSDictionary actionParams) {
        return new DefaultLoginResponder(actionParams);
    }

    public class DefaultLoginResponder implements CktlLoginResponder {
        private NSDictionary actionParams;

        public DefaultLoginResponder(NSDictionary actionParams) {
            this.actionParams = actionParams;
        }

        public NSDictionary actionParams() {
            return actionParams;
        }

        public WOComponent loginAccepted(CktlLogin loginComponent) {
            WOComponent nextPage = null;
            nextPage = cktlApp.pageWithName(Main.class.getName(), context());
            // TODO Decommenter la ligne precedente et commenter la suivante si vous ne souhaitez pas beneficier d'une page d'accueil et d'un wrapper horizontal
//            nextPage = cktlApp.pageWithName(Main.class.getName(), context());
            return nextPage;
        }

        public boolean acceptLoginName(String loginName) {
            return cktlApp.acceptLoginName(loginName);
        }

        public boolean acceptEmptyPassword() {
            return cktlApp.config().booleanForKey("ACCEPT_EMPTY_PASSWORD");
        }

        public String getRootPassword() {
            return cktlApp.getRootPassword();
        }
    }
	

}
