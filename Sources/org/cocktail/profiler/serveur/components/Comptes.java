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

import java.util.UUID;

import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompteSamba;
import org.cocktail.fwkcktlpersonne.common.metier.EOVlans;
import org.cocktail.fwkcktlpersonneguiajax.serveur.components.CompteUI;
import org.cocktail.fwkcktlwebapp.server.CktlConfig;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.UtilMessages;
import org.cocktail.sync.ref.SynchroPasswordPersonne;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXStringUtilities;

public class Comptes extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static final String APP_FLAG_PASSWORD_CLAIR = "APP_PASSWORD_EN_CLAIR";
	
	
	private String changePwdId = ERXStringUtilities
			.safeIdentifierName("changePwdId" + UUID.randomUUID());

	private String erreurContainerid = ERXStringUtilities
			.safeIdentifierName("erreurContainerid" + UUID.randomUUID());

	private String messageid = ERXStringUtilities
			.safeIdentifierName("messageid" + UUID.randomUUID());

	private String aucTriggerPwdId = ERXStringUtilities
			.safeIdentifierName("aucTriggerPwdId" + UUID.randomUUID());

	private String frmid = ERXStringUtilities.safeIdentifierName("frmid"
			+ UUID.randomUUID());

	private String aucchangepwd = ERXStringUtilities
			.safeIdentifierName("aucchangepwd" + UUID.randomUUID());

	private String defaultPassword;
	private String libDefaultPassword;
	public boolean isInChange = false;
	public boolean isSavInProgress = false;
	private NSArray<String> lstRefreshZones;
	private String saveOk;
	private String styleDefault = "background-color:#FFFFFF;";
	private String stylePb = "background-color:#FFEAEA;";
	private String styleNewPwd;

	public Comptes(WOContext context) {
		super(context);
		setLstRefreshZones(new NSArray<String>(new String[] {
				erreurContainerid, frmid }));
		
	}

	public EOCompte getSelectedCompte() {
		if (hasBinding(CompteUI.BINDING_selectedCompte)) {
			((Session) session())
					.setSelectedCompte((EOCompte) valueForBinding(CompteUI.BINDING_selectedCompte));
		}
		return ((Session) session()).getSelectedCompte();
	}

	public void setSelectedCompte(EOCompte compte) {
		if (canSetValueForBinding(CompteUI.BINDING_selectedCompte))
			setValueForBinding(compte, CompteUI.BINDING_selectedCompte);

		((Session) session()).setSelectedCompte(compte);
	}

	private NSArray<EOVlans> vlanCreation;

	/**
	 * @return the vlanCreation
	 */
	public NSArray<EOVlans> vlanCreation() {
		if (hasBinding(CompteUI.BINDING_vlansAutorisesPourCreation))
			vlanCreation = (NSArray<EOVlans>) valueForBinding(CompteUI.BINDING_vlansAutorisesPourCreation);
		if (vlanCreation == null)
			vlanCreation = new NSArray<EOVlans>();
		return vlanCreation;
	}

	/**
	 * @param vlanCreation
	 *            the vlanCreation to set
	 */
	public void setVlanCreation(NSArray<EOVlans> vlanCreation) {
		this.vlanCreation = vlanCreation;
		if (canSetValueForBinding(CompteUI.BINDING_vlansAutorisesPourCreation))
			setValueForBinding(vlanCreation,
					CompteUI.BINDING_vlansAutorisesPourCreation);
	}

	public boolean canChangePwd() {
		return getPuser().canChangePwd(getSelectedCompte(), editedPersonne());
	}

	public String getChangePwdId() {
		return changePwdId;
	}

	public String onClickChangePwd() {

		return "function (open) {openAMD_" + changePwdId + "();}";
	}

	private String newPwd;

	/**
	 * @return the newPwd
	 */
	public String newPwd() {
		return newPwd;
	}

	/**
	 * @param newPwd
	 *            the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	private String newPwd2;

	/**
	 * @return the newPwd2
	 */
	public String newPwd2() {
		return newPwd2;
	}

	/**
	 * @param newPwd2
	 *            the newPwd2 to set
	 */
	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

	/**
	 * @return the erreurContainerid
	 */
	public String erreurContainerid() {
		return erreurContainerid;
	}

	/**
	 * @param erreurContainerid
	 *            the erreurContainerid to set
	 */
	public void setErreurContainerid(String erreurContainerid) {
		this.erreurContainerid = erreurContainerid;
	}

	/**
	 * @return the messageid
	 */
	public String messageid() {
		return messageid;
	}

	/**
	 * @param messageid
	 *            the messageid to set
	 */
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	/**
	 * @return the aucTriggerPwdId
	 */
	public String aucTriggerPwdId() {
		return aucTriggerPwdId;
	}

	/**
	 * @param aucTriggerPwdId
	 *            the aucTriggerPwdId to set
	 */
	public void setAucTriggerPwdId(String aucTriggerPwdId) {
		this.aucTriggerPwdId = aucTriggerPwdId;
	}

	/**
	 * @return the lstRefreshZones
	 */
	public NSArray<String> lstRefreshZones() {
		return lstRefreshZones;
	}

	/**
	 * @param lstRefreshZones
	 *            the lstRefreshZones to set
	 */
	public void setLstRefreshZones(NSArray<String> lstRefreshZones) {
		this.lstRefreshZones = lstRefreshZones;
	}

	public String scriptCloseDialog() {

		return "if ((!$('" + messageid + "').visible())&&(" + saveOk
				+ "==true)) {Modalbox.hide(); }";
	}

	/**
	 * @return the frmid
	 */
	public String frmid() {
		return frmid;
	}

	/**
	 * @param frmid
	 *            the frmid to set
	 */
	public void setFrmid(String frmid) {
		this.frmid = frmid;
	}

	public WOActionResults validNewPwd() {
		if (isSavInProgress){
			return null;
		}
		isSavInProgress = true;
		styleNewPwd = styleDefault;
		styleNewPwd2 = styleDefault;
		saveOk = "false";
		if ((newPwd == null) || ("".equals(newPwd))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Le mot de passe est obligatoire !!");
			styleNewPwd = stylePb;
			isSavInProgress = false;
//			AjaxModalDialog.update(context(), null); 
			return null;
		}
		if ((newPwd2 == null) || ("".equals(newPwd2))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"La confirmation du mot de passe est obligatoire !!");
			styleNewPwd2 = stylePb;
			isSavInProgress = false;
//			AjaxModalDialog.update(context(), null); 
			return null;
		}

		if (!newPwd.equals(newPwd2)) {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Les mots de passe ne sont pas identiques !!");
			styleNewPwd = stylePb;
			styleNewPwd2 = stylePb;
			isSavInProgress = false;
//			AjaxModalDialog.update(context(), null); 
			return null;
		}
		CktlConfig config = ((Application) application()).config();
		try {
			EOCompte localCompte = getSelectedCompte().localInstanceIn(getEc());
			localCompte.changePassword(getPuser(), newPwd, config.booleanForKey(Comptes.APP_FLAG_PASSWORD_CLAIR) , config.booleanForKey(EOCompteSamba.APP_FLAG_PROPERTY_KEY));
			getEc().saveChanges();
		} catch (ValidationException e){
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE, e.getMessage());
			isSavInProgress = false;
			isPwdChanged = false;
			getEc().revert();
			return null;
		} catch (Exception e) {
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE, e.getMessage());
			isSavInProgress = false;
			isPwdChanged = false;
			//AjaxModalDialog.update(context(), null);
			getEc().revert();
			return null;
		}
		// Tout s'est bien passé en base
		
		// On synchronise si besoin
		if ("YES".equals(config.stringForKey("USE_SYNCREF_PWD"))) {
		    try {
		        SynchroPasswordPersonne.synchroPasswordPersonne(Integer.toString(getSelectedCompte().persId()));
		    } catch (Exception e) {
		    	handleSyncError(e);
		    }
		}
		saveOk = "true";
		UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE, "Le mot de passe a été changé avec succès !\n" );
		isPwdChanged = true;
		isSavInProgress = false;
//		AjaxModalDialog.update(context(), null); 
		return null;
	}

	private void handleSyncError(Exception e) {
		e.printStackTrace();
		UtilMessages
				.creatMessageUtil(
						session(),
						UtilMessages.ERROR_MESSAGE,
						"Mot de passe changé dans la base mais il y a eu une erreur du serveur de synchronisation :\n"
								+ e.getMessage());
		isSavInProgress = false;
	}

	public WOActionResults iniPwdChange() {
		saveOk = "false";
		styleNewPwd = styleDefault;
		styleNewPwd2 = styleDefault;
		newPwd = "";
		newPwd2 = "";
		isInChange = true;
		isPwdChanged = false;

		// verfi si la procedure Oracle GRHUM.DEFAULT_PASSWORD_FOR_COMPTE
		// retourne un mot de passe par defaut
//		NSDictionary<Object, Object> args = new NSDictionary<Object, Object>(
//				new Object[] {
//						(Number) EOUtilities.primaryKeyForObject(
//								getSelectedCompte().editingContext(),
//								getSelectedCompte()).objectForKey("cptOrdre"),
//						NSKeyValueCoding.NullValue, NSKeyValueCoding.NullValue },
//				new Object[] { "cptOrdre", "libelle", "pwd" });
//		NSDictionary<Object, Object> retour = null;
//		try {
//			retour = EOUtilities.executeStoredProcedureNamed(getEc(),
//					"defaultPasswordForCompte", args);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (NSKeyValueCoding.NullValue != retour.valueForKey("pwd")) {
//			defaultPassword = (String) retour.valueForKey("pwd");
//			libDefaultPassword = (String) retour.valueForKey("libelle") + " ("
//					+ defaultPassword + ")";
//		}

		return null;
	}

	/**
	 * @return the styleNewPwd
	 */
	public String styleNewPwd() {
		if (styleNewPwd == null)
			styleNewPwd = styleDefault;
		return styleNewPwd;
	}

	/**
	 * @param styleNewPwd
	 *            the styleNewPwd to set
	 */
	public void setStyleNewPwd(String styleNewPwd) {
		this.styleNewPwd = styleNewPwd;
	}

	private String styleNewPwd2;

	/**
	 * @return the styleNewPwd2
	 */
	public String styleNewPwd2() {
		if (styleNewPwd2 == null)
			styleNewPwd2 = styleDefault;
		return styleNewPwd2;
	}

	/**
	 * @param styleNewPwd2
	 *            the styleNewPwd2 to set
	 */
	public void setStyleNewPwd2(String styleNewPwd2) {
		this.styleNewPwd2 = styleNewPwd2;
	}

	/**
	 * @return the aucchangepwd
	 */
	public String aucchangepwd() {
		return aucchangepwd;
	}

	/**
	 * @param aucchangepwd
	 *            the aucchangepwd to set
	 */
	public void setAucchangepwd(String aucchangepwd) {
		this.aucchangepwd = aucchangepwd;
	}

	public WOActionResults cancelChange() {
		isInChange = false;
		return null;
	}

	private boolean isPwdChanged = false;

	/**
	 * @return the isPwdChanged
	 */
	public boolean isPwdChanged() {
		return isPwdChanged;
	}

	/**
	 * @param isPwdChanged
	 *            the isPwdChanged to set
	 */
	public void setPwdChanged(boolean isPwdChanged) {
		this.isPwdChanged = isPwdChanged;
	}

	public boolean haveDefaultPwd() {
		return (defaultPassword != null && !"".equals(defaultPassword)
				&& !defaultPassword.equals(newPwd) && !defaultPassword
				.equals(newPwd2));
	}

	public String getLibDefaultPassword() {
		return libDefaultPassword;
	}

	public void setLibDefaultPassword(String libDefaultPassword) {
		this.libDefaultPassword = libDefaultPassword;
	}

	public WOActionResults initPassword() {
		setNewPwd(defaultPassword);
		setNewPwd2(defaultPassword);
		return null;
	}

	public Integer utilPersid() {
		return ((Session) session()).getPUser().getPersId();
	}
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour permettre
	 * de bloquer le bouton de changement de mot de passe.
	 */
	public boolean changePwdDisabled(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_COMPTE_PWD_DESACTIVE) ){
//		if(ERXProperties.booleanForKey("org.cocktail.profiler.passwordchanged.disabled")) {
			return false;
		}
		return true;
	}
}