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

import java.util.GregorianCalendar;

import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.fwkcktlwebapp.server.CktlWebSession;
import org.cocktail.fwkcktlwebapp.server.components.CktlWebPage;
import org.cocktail.fwkcktlwebapp.server.util.EOModelCtrl;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.profiler.serveur.VersionMe;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORedirect;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eoaccess.EOModelGroup;
import com.webobjects.foundation.NSMutableArray;

public class Wrapper extends CktlWebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -16040081176556634L;
	private String titre;
	private String connectionBase;
    public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Wrapper(WOContext context) {
        super(context);
    }
	
	public String copyright() {
		return "(c) " + DateCtrl.nowDay().get(GregorianCalendar.YEAR) +" Association Cocktail";
	}

	public String version() {
		return VersionMe.htmlAppliVersion();
	}

	public boolean isConnected() {
		return (cktlSession().connectedUserInfo() != null);
	}
	
	/**
	 * @return the connectionBase
	 */
	public String connectionBase() {
		if (connectionBase == null) {
			connectionBase = "";
			EOModelGroup vModelGroup = EOModelGroup.defaultGroup();
			NSMutableArray<String> lstUrl = new NSMutableArray<String>();
			for (int i = 0; i < vModelGroup.models().count(); i++) {
				EOModel tmpEOModel = (EOModel) vModelGroup.models()
						.objectAtIndex(i);
				String urlModel = EOModelCtrl.bdConnexionUrl(tmpEOModel);
				urlModel = urlModel.substring(urlModel.lastIndexOf(":")+1);
				if (!lstUrl.contains(urlModel) && !urlModel.equals("n/a"))
					lstUrl.addObject(urlModel);
			}
//			Iterator<String> it = lstUrl.iterator();
//			while (it.hasNext()) {
//				connectionBase += (String) it.next() + "; ";
//			}
			connectionBase = lstUrl.componentsJoinedByString(",");
		}

		return connectionBase;
	}
	
	public WOActionResults killSession() {
		String url = cktlApp.mainWebSiteURL();
		
		if (url != null){
			return ((CktlWebSession)session()).goToMainSite();
		} else {
			url = context().directActionURLForActionNamed("default", null);
			WORedirect redirect = new WORedirect(context());
			redirect.setUrl(url);
			session().terminate();
			return redirect;
		}
		
	}
	
//	/**
//	 * Blocage du Logo de l'établissement si le parametre <code>MAIN_LOGO_URL"</code> dans la configuration de l'application (fichier
//	 * .config) est vide ou inexistant.
//	 */
//	
//	public boolean isMainLogoURLBlocked() {
//		if (cktlApp().mainLogoURL() == null 
//				|| cktlApp().mainLogoURL().equals("")
//					|| cktlApp().mainLogoURL().equals(" ")){
//			return false;
//		}
//		return true;
//	}
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour permettre
	 * de bloquer l'affichage de la base de données.
	 */
	public boolean hasDBViewDisabled(){
		if (((Application)application()).config().booleanForKey(ProfilerParamManager.PROFILER_BDD_AFFICHAGE_DESACTIVE) ){
			return true;
		}
		return false;
	}
}