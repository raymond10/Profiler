package org.cocktail.profiler.serveur;

import org.cocktail.fwkcktldroitsutils.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.PersonneApplicationUser;
import org.cocktail.fwkcktlpersonne.common.metier.EOGrhumParametres;
import org.cocktail.fwkcktlpersonne.common.metier.EOGrhumParametresType;
import org.cocktail.fwkcktlwebapp.server.CktlParamManager;

import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEOAccessUtilities;
import er.extensions.foundation.ERXThreadStorage;

public class ProfilerParamManager extends CktlParamManager {
	
	public static final String PROFILER_ADRESSE_PERSO_DESACTIVE = "org.cocktail.profiler.adresse.personaladressmodification.disabled";
	public static final String PROFILER_ADRESSE_READONLY_ACTIVE = "org.cocktail.profiler.adresse.readonly.enabled";
	public static final String PROFILER_TEL_READONLY_ACTIVE = "org.cocktail.profiler.telephone.readonly.enabled";
	//Ajout RN
	public static final String PROFILER_BUREAU_READONLY_ACTIVE = "org.cocktail.profiler.bureau.readonly.enabled";
	public static final String PROFILER_BUREAU_AFFICHAGE_ACTIVE = "org.cocktail.profiler.bureau.affichage.enabled";
	public static final String PROFILER_BDD_AFFICHAGE_DESACTIVE = "org.cocktail.profiler.bdd.view.disabled";
	
	public static final String PROFILER_TEL_INT_DESACTIVE = "org.cocktail.profiler.telephone.internetelmodification.disabled";
	public static final String PROFILER_TEL_PRF_DESACTIVE = "org.cocktail.profiler.telephone.protelmodification.disabled";
	public static final String PROFILER_COMPTE_PWD_DESACTIVE = "org.cocktail.profiler.compte.changedpassword.disabled";
	public static final String PROFILER_COMPTE_SECRETQUESTION_DESACTIVE = "org.cocktail.profiler.compte.secretquestion.disabled";
	public static final String PROFILER_PHOTO_READONLY_ACTIVE = "org.cocktail.profiler.photo.readonly.enabled";
	public static final String PROFILER_AGENDA_VISIBLE_ACTIVE = "org.cocktail.profiler.individu.agendavisible.enabled";
	public static final String PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE = "org.cocktail.profiler.scolarite.affichagecustom.enabled";
	

	private EOEditingContext ec = ERXEC.newEditingContext();
	
	public ProfilerParamManager() {
		getParamList().add(PROFILER_ADRESSE_PERSO_DESACTIVE);
		getParamComments().put(PROFILER_ADRESSE_PERSO_DESACTIVE, "Autoriser ou non un individu à modifier son adresse personnelle");
		getParamDefault().put(PROFILER_ADRESSE_PERSO_DESACTIVE, "N");
		getParamTypes().put(PROFILER_ADRESSE_PERSO_DESACTIVE, EOGrhumParametresType.codeActivation);
		
		getParamList().add(PROFILER_TEL_INT_DESACTIVE);
		getParamComments().put(PROFILER_TEL_INT_DESACTIVE, "Autoriser ou non un individu à modifier son numéro de téléphone interne");
		getParamDefault().put(PROFILER_TEL_INT_DESACTIVE, "N");
		getParamTypes().put(PROFILER_TEL_INT_DESACTIVE, EOGrhumParametresType.codeActivation);
		
		getParamList().add(PROFILER_TEL_PRF_DESACTIVE);
		getParamComments().put(PROFILER_TEL_PRF_DESACTIVE, "Autoriser ou non un individu à modifier son numéro de téléphone interne");
		getParamDefault().put(PROFILER_TEL_PRF_DESACTIVE, "N");
		getParamTypes().put(PROFILER_TEL_PRF_DESACTIVE, EOGrhumParametresType.codeActivation);
		
		getParamList().add(PROFILER_COMPTE_PWD_DESACTIVE);
		getParamComments().put(PROFILER_COMPTE_PWD_DESACTIVE, "Autoriser ou non un individu à modifier son password");
		getParamDefault().put(PROFILER_COMPTE_PWD_DESACTIVE, "N");
		getParamTypes().put(PROFILER_COMPTE_PWD_DESACTIVE, EOGrhumParametresType.codeActivation);

		getParamList().add(PROFILER_COMPTE_SECRETQUESTION_DESACTIVE);
		getParamComments().put(PROFILER_COMPTE_SECRETQUESTION_DESACTIVE, "Autoriser ou non un individu à accéder à la question secrète");
		getParamDefault().put(PROFILER_COMPTE_SECRETQUESTION_DESACTIVE, "N");
		getParamTypes().put(PROFILER_COMPTE_SECRETQUESTION_DESACTIVE, EOGrhumParametresType.codeActivation);

		getParamList().add(PROFILER_PHOTO_READONLY_ACTIVE);
		getParamComments().put(PROFILER_PHOTO_READONLY_ACTIVE, "Mettre ou non la photo d'un individu en lecture seulement");
		getParamDefault().put(PROFILER_PHOTO_READONLY_ACTIVE, "N");
		getParamTypes().put(PROFILER_PHOTO_READONLY_ACTIVE, EOGrhumParametresType.codeActivation);

		getParamList().add(PROFILER_ADRESSE_READONLY_ACTIVE);
		getParamComments().put(PROFILER_ADRESSE_READONLY_ACTIVE, "Mettre ou non la ou les adresses d'un individu en lecture seulement");
		getParamDefault().put(PROFILER_ADRESSE_READONLY_ACTIVE, "N");
		getParamTypes().put(PROFILER_ADRESSE_READONLY_ACTIVE, EOGrhumParametresType.codeActivation);

		getParamList().add(PROFILER_TEL_READONLY_ACTIVE);
		getParamComments().put(PROFILER_TEL_READONLY_ACTIVE, "Mettre ou non le ou les téléphones d'un individu en lecture seulement");
		getParamDefault().put(PROFILER_TEL_READONLY_ACTIVE, "N");
		getParamTypes().put(PROFILER_TEL_READONLY_ACTIVE, EOGrhumParametresType.codeActivation);
		//Ajout RN
		getParamList().add(PROFILER_BUREAU_READONLY_ACTIVE);
		getParamComments().put(PROFILER_BUREAU_READONLY_ACTIVE, "Activer ou désactiver l'affichage en mode 'Read Only' de la localisation d'un individu (Défaut : N)");
		getParamDefault().put(PROFILER_BUREAU_READONLY_ACTIVE, "N");
		getParamTypes().put(PROFILER_BUREAU_READONLY_ACTIVE, EOGrhumParametresType.codeActivation);
		
		getParamList().add(PROFILER_BUREAU_AFFICHAGE_ACTIVE);
	    getParamComments().put(PROFILER_BUREAU_AFFICHAGE_ACTIVE, "Activer ou désactiver l'affichage de la localisation d'un individu (Défaut : N)");
	    getParamDefault().put(PROFILER_BUREAU_AFFICHAGE_ACTIVE, "N");
	    getParamTypes().put(PROFILER_BUREAU_AFFICHAGE_ACTIVE, EOGrhumParametresType.codeActivation);
	    
	    getParamList().add(PROFILER_BDD_AFFICHAGE_DESACTIVE);
		getParamComments().put(PROFILER_BDD_AFFICHAGE_DESACTIVE, "Activer ou désactiver l'affichage de la base de données");
		getParamDefault().put(PROFILER_BDD_AFFICHAGE_DESACTIVE, "N");
		getParamTypes().put(PROFILER_BDD_AFFICHAGE_DESACTIVE, EOGrhumParametresType.codeActivation);
	    //

		getParamList().add(PROFILER_AGENDA_VISIBLE_ACTIVE);
		getParamComments().put(PROFILER_AGENDA_VISIBLE_ACTIVE, "Activer ou désactiver la visibilité des agendas d'un individu");
		getParamDefault().put(PROFILER_AGENDA_VISIBLE_ACTIVE, "O");
		getParamTypes().put(PROFILER_AGENDA_VISIBLE_ACTIVE, EOGrhumParametresType.codeActivation);
		
		getParamList().add(PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE);
		getParamComments().put(PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE, "Activer ou désactiver l'affichage customisé de la Scolarité (Défaut : N)");
		getParamDefault().put(PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE, "N");
		getParamTypes().put(PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE, EOGrhumParametresType.codeActivation);
	}
	
	@Override
	public void createNewParam(String key, String value, String comment) {
		createNewParam(key, value, comment, EOGrhumParametresType.codeActivation);
	}
	
	@Override
	public void checkAndInitParamsWithDefault() {
		//Recuperer un grhum_createur
		String cptLogin = EOGrhumParametres.parametrePourCle(ec, EOGrhumParametres.PARAM_GRHUM_CREATEUR);
		if (cptLogin != null) {
			EOCompte cpt = EOCompte.compteForLogin(ec, cptLogin);
			if (cpt != null) {
				ERXThreadStorage.takeValueForKey(cpt.persId(), PersonneApplicationUser.PERS_ID_CURRENT_USER_STORAGE_KEY);
			}
		}
		super.checkAndInitParamsWithDefault();
	}

	@Override
	public void createNewParam(String key, String value, String comment,
			String type) {
		EOGrhumParametres newParametre = EOGrhumParametres.creerInstance(ec);
		newParametre.setParamKey(key);
		newParametre.setParamValue(value);
		newParametre.setParamCommentaires(comment);
		newParametre.setToParametresTypeRelationship(EOGrhumParametresType.fetchByKeyValue(ec, EOGrhumParametresType.TYPE_ID_INTERNE_KEY, type));
		if (ec.hasChanges()) {
			EOEntity entityParameter = ERXEOAccessUtilities.entityForEo(newParametre);
			try {

				// Avant de sauvegarder les données, nous modifions le modèle
				// pour que l'on puisse avoir accès aussi en écriture sur les données
				entityParameter.setReadOnly(false);
				ec.saveChanges();

			} catch (Exception e) {
				log.warn("Erreur lors de l'enregistrement des parametres.");
				e.printStackTrace();
			} finally {
				entityParameter.setReadOnly(true);
			}
		}
	}

	@Override
	public String getParam(String key) {
		String res = getApplication().config().stringForKey(key);
		//		String res = EOGrhumParametres.parametrePourCle(ec, key);
		return res;
	}

}
