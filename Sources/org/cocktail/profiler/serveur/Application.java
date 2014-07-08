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

import java.sql.Connection;
import java.util.TimeZone;

import org.cocktail.fwkcktlajaxwebext.serveur.CocktailAjaxApplication;
import org.cocktail.fwkcktldroitsutils.common.util.MyStringCtrl;
import org.cocktail.fwkcktlpersonne.common.FwkCktlPersonneParamManager;
import org.cocktail.fwkcktlpersonne.common.metier.EOGrhumParametres;
import org.cocktail.fwkcktlpersonneguiajax.serveur.FwkCktlPersonneGuiAjaxParamManager;
import org.cocktail.fwkcktlwebapp.common.CktlLog;
import org.cocktail.fwkcktlwebapp.server.CktlParamManager;
import org.cocktail.fwkcktlwebapp.server.database.CktlDataBus;
import org.cocktail.fwkcktlwebapp.server.version.A_CktlVersion;
import org.cocktail.profiler.serveur.components.Main;
import org.cocktail.profiler.serveur.components.Wrapper;

import com.webobjects.eoaccess.EOAdaptorChannel;
import com.webobjects.eoaccess.EOAdaptorContext;
import com.webobjects.eoaccess.EODatabaseContext;
import com.webobjects.foundation.NSTimeZone;
import com.webobjects.foundation.NSTimestampFormatter;
import com.webobjects.foundation._NSUtilities;
import com.webobjects.jdbcadaptor.JDBCContext;

import er.extensions.appserver.ERXApplication;

public class Application extends CocktailAjaxApplication {
	private static final String CONFIG_FILE_NAME = VersionMe.APPLICATIONINTERNALNAME + ".config";
	private static final String CONFIG_TABLE_NAME = "FwkCktlWebApp_GrhumParametres";
	// On ne passait pas un modèle donc il y avait des soucis.
//	private static final String MAIN_MODEL_NAME = VersionMe.APPLICATIONINTERNALNAME;
	private static final String MAIN_MODEL_NAME = "FwkCktlPersonne";
	public static final String CAN_PRINT_CERTIF_SCOL = "CAN_PRINT_CERTIF_SCOL";
	public static final String SHOW_SCOL = "SHOW_SCOL";
	
	public static ProfilerParamManager profilerParamManager = new ProfilerParamManager();
	/**
	 * Liste des parametres obligatoires (dans fichier de config ou table
	 * grhum_parametres) pour que l'application se lance. Si un des parametre
	 * n'est pas initialisÃ©, il y a une erreur bloquante.
	 */
	public static final String[] MANDATORY_PARAMS = new String[] {};

	/**
	 * Liste des parametres optionnels (dans fichier de config ou table
	 * grhum_parametres). Si un des parametre n'est pas initialisÃ©, il y a un
	 * warning.
	 */
	public static final String[] OPTIONAL_PARAMS = new String[] {};

	/**
	 * Mettre Ã  true pour que votre application renvoie les informations de
	 * collecte au serveur de collecte de Cocktail.
	 */
	public static final boolean APP_SHOULD_SEND_COLLECTE = false;

	public final NSTimestampFormatter _dateHourFormat = new NSTimestampFormatter("%d/%m/%Y %H:%M");

	public static NSTimeZone ntz = null;

	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	private Version _appVersion;
	private Boolean isPhotoEnabled;

	public Application() {
		super();
	}

	public void initApplication() {
		System.out.println("Lancement de l'application serveur " + this.name() + "...");
		super.initApplication();
		initTimeZones();
		// FIX un pb de classpath
		_NSUtilities.setClassForName(Main.class, "Main");
		_NSUtilities.setClassForName(Wrapper.class, "Wrapper");
		// Afficher les infos de connexion des modeles de donnees
		rawLogModelInfos();
		// Verifier la coherence des dictionnaires de connexion des modeles de
		// donnees
		boolean isInitialisationErreur = !checkModel();
		System.out.println(isInitialisationErreur);
		// TODO ajouter votre code pour l'initialisation
	}

	/**
	 * @return La connection JDBC vers la base de donnÃ¯Â¿Â½es.
	 */
	public Connection getJDBCConnection() {
		return ((JDBCContext) getAdaptorContext()).connection();
	}

	/**
	 * Utile pour rÃ¯Â¿Â½cupÃ¯Â¿Â½rer la connection vers la base de
	 * donnÃ¯Â¿Â½es.
	 * 
	 * @return
	 */
	public EOAdaptorContext getAdaptorContext() {
		return getAdaptorChannel().adaptorContext();
	}

	public EODatabaseContext getDatabaseContext() {
		return CktlDataBus.databaseContext();
	}

	public EOAdaptorChannel getAdaptorChannel() {
		return getDatabaseContext().availableChannel().adaptorChannel();
	}

	public String configFileName() {
		return CONFIG_FILE_NAME;
	}

	public String configTableName() {
		return CONFIG_TABLE_NAME;
	}

	public String[] configMandatoryKeys() {
		return MANDATORY_PARAMS;
	}

	public String[] configOptionalKeys() {
		return OPTIONAL_PARAMS;
	}

	public boolean appShouldSendCollecte() {
		return APP_SHOULD_SEND_COLLECTE;
	}

	public String copyright() {
		return appVersion().copyright();
	}

	public A_CktlVersion appCktlVersion() {
		return appVersion();
	}

	public Version appVersion() {
		if (_appVersion == null) {
			_appVersion = new Version();
		}
		return _appVersion;
	}

	public String mainModelName() {
		return MAIN_MODEL_NAME;
	}

	protected void initTimeZones() {
		CktlLog.log("Initialisation du NSTimeZone");
		String tz = config().stringForKey("DEFAULT_NS_TIMEZONE");
		if (tz == null || tz.equals("")) {
			CktlLog.log("Le parametre DEFAULT_NS_TIMEZONE n'est pas defini dans le fichier .config.");
			TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
			NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName("Europe/Paris", false));
		} else {
			ntz = NSTimeZone.timeZoneWithName(tz, false);
			if (ntz == null) {
				CktlLog.log("Le parametre DEFAULT_NS_TIMEZONE defini dans le fichier .config n'est pas valide (" + tz
						+ ")");
				TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
				NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName("Europe/Paris", false));
			} else {
				TimeZone.setDefault(ntz);
				NSTimeZone.setDefaultTimeZone(ntz);
			}
		}
		ntz = NSTimeZone.defaultTimeZone();
		CktlLog.log("NSTimeZone par defaut utilise dans l'application:" + NSTimeZone.defaultTimeZone());
		NSTimestampFormatter ntf = new NSTimestampFormatter();
		CktlLog.log("Les NSTimestampFormatter analyseront les dates avec le NSTimeZone: " + ntf.defaultParseTimeZone());
		CktlLog.log("Les NSTimestampFormatter afficheront les dates avec le NSTimeZone: " + ntf.defaultFormatTimeZone());
	}
	
	/**
	 * @return the isPhotoEnabled
	 */
	public boolean isPhotoEnabled() {
		if (isPhotoEnabled==null) {
			String paramPhoto = (String)config().get(EOGrhumParametres.PARAM_GRHUM_PHOTO);
			if (MyStringCtrl.isEmpty(paramPhoto)) {
				paramPhoto = "NON";
			}
			setIsPhotoEnabled(Boolean.valueOf(paramPhoto.startsWith("OUI")));
		}
		return isPhotoEnabled.booleanValue();
	}

	/**
	 * @param isPhotoEnabled the isPhotoEnabled to set
	 */
	private void setIsPhotoEnabled(Boolean isPhotoEnabled) {
		this.isPhotoEnabled = isPhotoEnabled;
	}
	
	@Override
	public void finishInitialization() {
		// TODO Auto-generated method stub
		super.finishInitialization();
		
		profilerParamManager.checkAndInitParamsWithDefault();
		CktlParamManager.copyParamValue(ProfilerParamManager.PROFILER_ADRESSE_PERSO_DESACTIVE, FwkCktlPersonneGuiAjaxParamManager.PERSONNE_ADRESSE_PERSO_DESACTIVE);
		CktlParamManager.copyParamValue(ProfilerParamManager.PROFILER_TEL_INT_DESACTIVE, FwkCktlPersonneGuiAjaxParamManager.PERSONNE_TEL_INT_DESACTIVE);
		CktlParamManager.copyParamValue(ProfilerParamManager.PROFILER_TEL_PRF_DESACTIVE, FwkCktlPersonneGuiAjaxParamManager.PERSONNE_TEL_PRF_DESACTIVE);
		//CktlParamManager.copyParamValue(ProfilerParamManager.PROFILER_BUREAUX_READONLY_ACTIVE, FwkCktlPersonneGuiAjaxParamManager.PROFILER_BUREAUX_READONLY_ACTIVE);
		// Il n'y a a priori pas de modification possible du N° INSEE au niveau de Profiler (CF. Agrhum ou Mangue)
		// donc on ne désactive pas le contrôle de cohérence du N° INSEE
		FwkCktlPersonneParamManager.setParamValue(FwkCktlPersonneParamManager.INDIVIDU_CHECK_COHERENCE_INSEE_DISABLED, "NON");
	}

}
