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

import org.cocktail.fwkcktldroitsutils.common.ApplicationUser;
import org.cocktail.fwkcktldroitsutils.common.metier.EOUtilisateur;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartPersonneAdresse;
import org.cocktail.fwkcktlpersonne.common.metier.EORepartStructure;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public class ProfilerUser extends ApplicationUser {

	private String cStructureAdmin;

	/**
	 * Liste de types d'adresses qui ne sont pas modifiables
	 */
	private NSArray<String> typeAdrsNotModified = new NSArray<String>();

	/**
	 * Liste des VLAN dont le pwd du compte n'est pas modifiables
	 */
	private NSArray<String> vlansNotModified = new NSArray<String>();

	public ProfilerUser(EOEditingContext ec, String tyapStrId, Integer persId,
			String cStructureAdmin) {
		super(ec, tyapStrId, persId);
		this.cStructureAdmin = cStructureAdmin;

	}

	public ProfilerUser(EOEditingContext ec, String tyapStrId,
			EOUtilisateur utilisateur, String cStructureAdmin) {
		super(ec, tyapStrId, utilisateur);
		this.cStructureAdmin = cStructureAdmin;

	}

	public ProfilerUser(EOEditingContext ec, EOUtilisateur utilisateur,
			String cStructureAdmin) {
		super(ec, utilisateur);
		this.cStructureAdmin = cStructureAdmin;

	}

	public ProfilerUser(EOEditingContext ec, Integer persId,
			String cStructureAdmin) {
		super(ec, persId);
		this.cStructureAdmin = cStructureAdmin;

	}

	public String getCStructureAdmin() {
		return cStructureAdmin;
	}

	public void setCStructureAdmin(String structureAdmin) {
		cStructureAdmin = structureAdmin;
	}

	private Boolean haveAdminRight;

	/**
	 *retourne true si le user ayant le persid fait partie du groupe ayant le
	 * cStructureAdmin
	 * 
	 * @param cStructureAdmin
	 * @return boolean
	 */
	public boolean haveAdminRight() {
		if (haveAdminRight == null) {
			if (cStructureAdmin == null)
				haveAdminRight = new Boolean(false);
			else {
				EOQualifier myQual = EOQualifier.qualifierWithQualifierFormat(
						EORepartStructure.PERS_ID_KEY + " = %@ AND "
								+ EORepartStructure.C_STRUCTURE_KEY + " =%@",
						new NSArray<Object>(new Object[] { getPersId(),
								cStructureAdmin }));
				EOFetchSpecification mySpec = new EOFetchSpecification(
						EORepartStructure.ENTITY_NAME, myQual, null);

				haveAdminRight = (getEditingContext()
						.objectsWithFetchSpecification(mySpec).count() > 0);
			}
		}
		return haveAdminRight.booleanValue();

	}

	public boolean userCanUseAppli() {

		return true;

	}

	public boolean canEditAdresse(EORepartPersonneAdresse rpa) {
		if (rpa == null)
			return false;
		if (canEditAdresse(rpa.toPersonne())) {
			if (haveAdminRight())
				return true;

			if (this.getPersonne().persId().equals(rpa.toPersonne().persId())) {
				if (!typeAdrsNotModified.contains(rpa.toTypeAdresse()
						.tadrCode()))
					return true;
			}
		}
		return false;
	}
	
	public boolean canEditAdresse(IPersonne pers) {
		return (haveDroitsModification(pers)) ;
	}
	
	public boolean canEditTelephone(IPersonne pers) {
		return (haveDroitsModification(pers)) ;
	}


	public NSArray<String> getTypeAdrsNotModified() {
		return typeAdrsNotModified;
	}

	public void setTypeAdrsNotModified(NSArray<String> typeAdrsNotModified) {
		this.typeAdrsNotModified = typeAdrsNotModified;
	}

	public boolean canChangePwd(EOCompte cpt, IPersonne pers) {
		if (pers==null)
			return false;
		if (cpt == null)
			return false;
		
		if (haveDroitsModification(pers)) {
			if (haveAdminRight())
				return true;

			if (this.getPersonne().persId().equals(pers.persId())) {
				if ( !vlansNotModified.contains(cpt.toVlans().cVlan()) ){
					return true;
				}
			}
		}
		return false;
	}

	public NSArray<String> getVlansNotModified() {
		return vlansNotModified;
	}

	public void setVlansNotModified(NSArray<String> vlansNotModified) {
		this.vlansNotModified = vlansNotModified;
	}

	public boolean canChangePhoto(IPersonne pers) {
		return haveDroitsModification(pers);

		/*
		if (haveAdminRight())
			return true;

		if (this.getPersonne().persId().equals(persid)) {

			return true;

		}
		return false;
		//*/
	}

	public boolean canEditIcals(IPersonne pers) {
		return canChangePhoto(pers);
	}

	public static boolean isEtudiant(EOIndividu individu) {
		if (individu == null)
			return false;
		return "ETUDIANT".equals(individu.indQualite());
	}

	public boolean haveDroitsModification(IPersonne pers) {
		if (pers==null)
			return false;
		return pers.getPersonneDelegate()
				.hasPersonneUtilisateurDroitModification(
						this.getPersonne().persId());
	}

}
