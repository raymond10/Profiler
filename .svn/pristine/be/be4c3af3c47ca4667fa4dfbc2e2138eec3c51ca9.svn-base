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

import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.foundation.ERXStringUtilities;

public class InfosPerso extends ProfilBaseCmp {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String aucInfosPersoId = ERXStringUtilities.safeIdentifierName("aucInfosPerso"
			+ UUID.randomUUID());
	private String aucButtonInfosPersoId = ERXStringUtilities
	.safeIdentifierName("aucButtonInfosPerso" + UUID.randomUUID());
	
	public InfosPerso(WOContext context) {
        super(context);
    }

	private EOEditingContext ecAdrs;

	/**
	 * @return the getEcAdrs
	 */
	public EOEditingContext getEcAdrs() {
		if (ecAdrs==null)
			ecAdrs = new EOEditingContext(getEc());
		return ecAdrs;
	}

	/**
	 * @param getEcAdrs the getEcAdrs to set
	 */
	public void setGetEcAdrs(EOEditingContext ecAdrs) {
		this.ecAdrs = ecAdrs;
		
	}
	
	/**
	 * Condition pré-calculer pour renvoyer une photo si l'on a à faire à un individu
	 */
	
	public boolean isIndividuWithPhoto(){
		
		return ( editedPersonne().isIndividu() && ((Application)application()).isPhotoEnabled() );
	}
	
	public boolean isEditedPersonne(){
//		return editedPersonne().isIndividu();
		return editedPersonne().isIndividu() && isAgendaInvisible();
	}
	
	public String getAucInfosPersoId() {
		return aucInfosPersoId;
	}
	
	public String getAucButtonInfosPersoId() {
		return aucButtonInfosPersoId;
	}
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que la photo
	 * soit seulement en mode affichage.
	 */
	public boolean isPhotoReadOnlyEnabled(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_PHOTO_READONLY_ACTIVE) ){
			return true;
		}
		return false;
	}
	
	  public boolean isLocated()
	  {
	    if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_BUREAU_AFFICHAGE_ACTIVE)) {
	      if (editedPersonne().isStructure()) {
	        return false;
	      }

	      return (!editedPersonne().isIndividu()) || (!((EOIndividu) editedPersonne()).isEtudiant());
	    }

	    return false;
	  }
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que les agendas
	 *  ne soient pas affichés.
	 */
	public boolean isAgendaInvisible(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_AGENDA_VISIBLE_ACTIVE) ){
			return true;
		}
		return false;
	}
	
}