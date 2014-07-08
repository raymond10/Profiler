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
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.profiler.serveur.Session;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXStringUtilities;

public class InfosCompte extends ProfilBaseCmp {
	public InfosCompte(WOContext context) {
		super(context);
	}

	/**
	 * 
	 * @return Les comptes valides associes a la personne.
	 */
	public NSArray<EOCompte> getLstComptes() {
		NSArray<EOCompte> res = new NSArray<EOCompte>();
		if (editedPersonne() != null) {
			res = editedPersonne().toComptes(EOCompte.QUAL_CPT_VALIDE_OUI);
			if (((Session) session()).getSelectedCompte() == null
					&& res.count() > 0) {
				((Session) session()).setSelectedCompte((EOCompte) res
						.objectAtIndex(0));
			}
		}
		return res;
	}

	public boolean isMultiComptes() {
		return getLstComptes().size() > 1;
	}

	private EOCompte unCompte;

	/**
	 * @return the unCompte
	 */
	public EOCompte unCompte() {
		return unCompte;
	}

	/**
	 * @param unCompte
	 *            the unCompte to set
	 */
	public void setUnCompte(EOCompte unCompte) {
		this.unCompte = unCompte;
	}

	private String infosCompteId = ERXStringUtilities
			.safeIdentifierName("infosCompteId" + UUID.randomUUID());

	/**
	 * @return the infosCompteId
	 */
	public String infosCompteId() {
		return infosCompteId;
	}

	/**
	 * @param infosCompteId
	 *            the infosCompteId to set
	 */
	public void setInfosCompteId(String infosCompteId) {
		this.infosCompteId = infosCompteId;
	}
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour permettre
	 * de bloquer le cadre de la question secrète.
	 */
	public boolean accederSecretQuestionDisabled(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_COMPTE_SECRETQUESTION_DESACTIVE) ){
			return false;
		}
		return true;
	}
}