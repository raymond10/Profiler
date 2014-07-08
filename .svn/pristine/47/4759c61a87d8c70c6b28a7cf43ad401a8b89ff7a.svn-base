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

import org.cocktail.fwkcktlpersonne.common.metier.EORepartPersonneAdresse;
import org.cocktail.profiler.serveur.ProfilerParamManager;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXStringUtilities;

public class AdrsZone extends ProfilBaseCmp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String aucAdrsId = ERXStringUtilities.safeIdentifierName("aucAdrs"
			+ UUID.randomUUID());
	private String aucButtonAdrsId = ERXStringUtilities
			.safeIdentifierName("aucButtonAdrs" + UUID.randomUUID());
	private String aucTriggerAdrsId = ERXStringUtilities
			.safeIdentifierName("aucTriggerAdrs" + UUID.randomUUID());

	public AdrsZone(WOContext context) {
		super(context);
		setLstEditZones(new NSArray<String>(new String[] { aucAdrsId,
				aucButtonAdrsId,auceditbtbid() }));

	}

	private EORepartPersonneAdresse selectedRepartPersonneAdresse;

	/**
	 * @return the selectedRepartPersonneAdresse
	 */
	public EORepartPersonneAdresse selectedRepartPersonneAdresse() {
		return selectedRepartPersonneAdresse;
	}

	/**
	 * @param selectedRepartPersonneAdresse
	 *            the selectedRepartPersonneAdresse to set
	 */
	public void setSelectedRepartPersonneAdresse(
			EORepartPersonneAdresse selectedRepartPersonneAdresse) {
		this.selectedRepartPersonneAdresse = selectedRepartPersonneAdresse;
	}

	@Override
	public boolean haveRight() {
		if (selectedRepartPersonneAdresse()!=null)
			return getPuser().canEditAdresse(selectedRepartPersonneAdresse());
		else
			return haveRightEditAdresse();
	}

	public String getAucAdrsId() {
		return aucAdrsId;
	}

	public String getAucButtonAdrsId() {
		return aucButtonAdrsId;
	}

	public String getAucTriggerAdrsId() {
		return aucTriggerAdrsId;
	}

//	public Boolean CanEditAdrs() {
//		// Le changement effectué sur le calcul de la valeur booléenne est dû au fait
//		// que l'on enregistre tout globalement maintenant et plus élément par élément.
////		return isNotEdited() && !haveModifications();
//		return isNotEdited();
//	}
	
	public Boolean haveRightEditAdresse(){
		return getPuser().canEditAdresse(editedPersonne()) ;
	}

	public String auceditbtbid() {
		return getComponentId()+"_auceditbtbid";
	}
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que les adresses
	 * soient seulement en mode affichage.
	 */
	public boolean isAdressReadOnlyEnabled(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_ADRESSE_READONLY_ACTIVE) ){
			return true;
		}
		return false;
	}

}