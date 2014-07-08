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
package org.cocktail.profiler.serveur.finder;

import org.cocktail.fwkcktlgrh.common.metier.EOIndividuDiplome;
import org.cocktail.fwkcktlpersonne.common.metier.EOEnfant;
import org.cocktail.fwkcktlpersonne.common.metier.EOEtudiant;
import org.cocktail.fwkcktlpersonne.common.metier.EOFournis;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EORib;
import org.cocktail.profiler.server.eof.EOHistorique;
import org.cocktail.profiler.server.eof.EOInscDipl;
import org.cocktail.profiler.server.eof.EOScolInscriptionEtudiant;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class FinderEtatCivil {

	/**
	 * Retourne le EODetailsIndividu d'un individu
	 */
//	public static EODetailsIndividu detailsForIndividu(EOEditingContext ec,
//			EOIndividu ind) {
//
//		if (ind == null) {
//			return null;
//		}
//		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(
//				EODetailsIndividu.NO_INDIVIDU_KEY + " = %@",
//				new NSArray<Object>(ind.noIndividu()));
//		EODetailsIndividu retour = EODetailsIndividu.fetchDetailsIndividu(ec,
//				qual);
//
//		return retour;
//	}

	/**
	 * Retourne les EOIndividuDiplomes d'un individu
	 */
	public static NSArray<EOIndividuDiplome> diplomesForIndividu(
			EOEditingContext ec, EOIndividu ind) {
		return EOIndividuDiplome.fetchAllForIndividu(ec, ind);
	}

	/**
	 * Retourne les EOEnfant d'un individu
	 */
	public static NSArray<EOEnfant> enfantsForIndividu(EOEditingContext ec,
			EOIndividu ind) {
		return EOEnfant.enfantsForIndividu(ec, ind);
	}

	/**
	 * Retourne les EORibfourUlr d'un individu
	 */
	public static NSArray<EORib> ribsForIndividu(EOEditingContext ec,
			EOIndividu ind) {
	    
		if (ind == null) {
			return null;
		}
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(
		        EORib.TO_FOURNIS_KEY + "." + EOFournis.PERS_ID_KEY + " = %@ AND "+EORib.RIB_VALIDE_KEY+" = %s ",
				new NSArray<Object>(new Object[]{ind.persId(),"O"}));
		NSArray<EOSortOrdering> sorts = new NSArray<EOSortOrdering>(
		        new EOSortOrdering(
                        EORib.D_CREATION_KEY,
                        EOSortOrdering.CompareCaseInsensitiveDescending));
		NSArray<EORib> retour = EORib.fetchAll(ec, qual, sorts);
		return retour;
	}

	/**
	 * Retourne l'étudiant correspondant à l'individu
	 */
	public static EOEtudiant etudiantForIndividu(EOEditingContext ec,
			EOIndividu ind) {
		EOEtudiant retour = EOEtudiant.etudiantForIndividu(ec, ind);
		return retour;
	}

	/**
	 * Recherche les historiques d'un étudiant
	 * 
	 * @param ec
	 * @param etud
	 * @return EOHistorique
	 */
	public static NSArray<EOHistorique> getHistoriqueForEtudiant(
			EOEditingContext ec, EOEtudiant etud) {
		if (etud==null)
			return null;
		return EOHistorique.fetchHistoriques(ec, new EOKeyValueQualifier(EOHistorique.ETUD_NUMERO_KEY,
				EOQualifier.QualifierOperatorEqual, etud.etudNumero()), new NSArray<EOSortOrdering>(new EOSortOrdering[]{new EOSortOrdering(EOHistorique.HIST_ANNEE_SCOL_KEY,EOSortOrdering.CompareAscending)}));
	}

	/**
	 * Recherche de la liste des inscriptions à un diplome pour l'étudiant
	 * "etud" 
	 * 
	 * @param ec
	 * @param etud
	 * @return array de la liste des inscriptions
	 */
	public static NSArray<EOInscDipl> getInscDiplForEtudiant(
			EOEditingContext ec, EOEtudiant etud) {
		if (etud==null)
			return null;
		NSArray<EOHistorique> histo = getHistoriqueForEtudiant(ec, etud);
		NSMutableArray<EOInscDipl> retour = null;
		if (histo!=null){
			retour = new NSMutableArray<EOInscDipl>();
			for (EOHistorique histoOccur : histo) {				
					retour.addObjectsFromArray(histoOccur.toInscDipls());
			}
		}
		return retour;
	}

	public static NSArray<EOScolInscriptionEtudiant> getScolInscriptionEtudiant(
			EOEditingContext ec, EOEtudiant etud) {
		if (etud==null)
			return null;
		
		return EOScolInscriptionEtudiant.fetchScolInscriptionEtudiants(ec, new EOKeyValueQualifier(EOScolInscriptionEtudiant.ETUD_NUMERO_KEY,
				EOQualifier.QualifierOperatorEqual, etud.etudNumero()), new NSArray<EOSortOrdering>(new EOSortOrdering[]{new EOSortOrdering(EOScolInscriptionEtudiant.FANN_KEY_KEY,EOSortOrdering.CompareAscending)}));
	}
}
