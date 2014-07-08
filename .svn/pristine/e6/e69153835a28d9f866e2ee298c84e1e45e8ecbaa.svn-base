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


import org.cocktail.fwkcktlgrh.common.metier.EOIndividuDiplome;
import org.cocktail.fwkcktlpersonne.common.metier.EOEnfant;
import org.cocktail.fwkcktlpersonne.common.metier.EOEtudiant;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EORib;
import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.finder.FinderEtatCivil;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class EtatCivil extends ProfilBaseCmp {
	private static final long serialVersionUID = 1L;

	private EOEnfant enfant;
	private EORib rib;
	private EOIndividuDiplome diplome;
	public String newLogin;

	private boolean _rowFlip; // used to alternate colors

	private EOEtudiant etudiant;

	public EOIndividu detailsIndividu() {
		Session sess = (Session) session();
		if (sess.detailsIndividu() == null)
			sess.setDetailsIndividu(
					getEditedIndividu());
		return sess.detailsIndividu();
	}

	public EOEtudiant getEtudiant() {
		return etudiant;
	}

	public NSArray<EOIndividuDiplome> lstDiplomes() {
		Session sess = (Session) session();

		if (sess.lstDiplomes() == null) {
			sess.setLstDiplomes(FinderEtatCivil.diplomesForIndividu(getEc(),
					getEditedIndividu()));
			etudiant = FinderEtatCivil.etudiantForIndividu(getEc(),
					getEditedIndividu());
		}
		return sess.lstDiplomes();
	}

	public NSArray<EOEnfant> lstEnfants() {
		Session sess = (Session) session();
		if (sess.lstEnfants() == null)
			sess.setLstEnfants(FinderEtatCivil.enfantsForIndividu(getEc(),
					getEditedIndividu()));
		return sess.lstEnfants();
	}

	public NSArray<EORib> lstRibs() {
		Session sess = (Session) session();
		if (sess.lstRibs() == null)
			sess.setLstRibs(FinderEtatCivil.ribsForIndividu(getEc(),
					getEditedIndividu()));
		return sess.lstRibs();
	}

	public EtatCivil(WOContext context) {
		super(context);
		newLogin = ((Session) session()).connectedUserInfo().login();
	}

	/**
	 * @return the enfant
	 */
	public EOEnfant enfant() {
		return enfant;
	}

	/**
	 * @param enfant
	 *            the enfant to set
	 */
	public void setEnfant(EOEnfant enfant) {
		this.enfant = enfant;
	}

	/**
	 * @return the rib
	 */
	public EORib rib() {
		return rib;
	}

	/**
	 * @param rib
	 *            the rib to set
	 */
	public void setRib(EORib rib) {
		this.rib = rib;
	}

	/**
	 * @return the diplome
	 */
	public EOIndividuDiplome diplome() {
		return diplome;
	}

	/**
	 * @param diplome
	 *            the diplome to set
	 */
	public void setDiplome(EOIndividuDiplome diplome) {
		this.diplome = diplome;
	}

	public String backgroundColorForRow() {
		_rowFlip = !_rowFlip;
		if (_rowFlip)
			return "pair";
		else
			return "impair";
	}

	/**
	 * @return the hasDiplomes
	 */
	public boolean hasDiplomes() {
		lstDiplomes();
		return (((Session) session()).lstDiplomes() != null && ((Session) session())
				.lstDiplomes().count() > 0)
				|| (etudiant != null && etudiant.toBac() != null);
	}
	
	/**
	 * @return the hasBac
	 */
	public boolean hasBac() {
		if (etudiant == null || getEtudiant().toBac() == null){
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * @return the hasRibs
	 */
	public boolean hasRibs() {
		boolean ownedRib = false;
		if (lstRibs().count() > 0){
			ownedRib = true;
		}
		return ownedRib;
		
	}
	
	/**
	 * @return the hasEnfants
	 */
	public boolean hasEnfants() {
		boolean ownChildren = false;
		if (lstEnfants().count() > 0){
			ownChildren = true;
		}
		return ownChildren;
		
	}
	
	public String getTimestampFormatter() {
		return DateCtrl.DEFAULT_FORMAT;
	}

}