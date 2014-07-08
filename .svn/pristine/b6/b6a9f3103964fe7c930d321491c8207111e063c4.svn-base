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


import org.cocktail.fwkcktlgrh.common.metier.EOAffectation;
import org.cocktail.fwkcktlgrh.common.metier.EOCarriere;
import org.cocktail.fwkcktlgrh.common.metier.EOContrat;
import org.cocktail.fwkcktlgrh.common.metier.EOElements;
import org.cocktail.fwkcktlwebapp.common.util.DateCtrl;
import org.cocktail.profiler.serveur.Session;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class InfosPro extends ProfilBaseCmp {
	private static final long serialVersionUID = 1L;

	public InfosPro(WOContext context) {
        super(context);
    }

	private EOCarriere carriere;

	private EOElements element;

	private boolean _rowFlip;

	private EOAffectation affectation;

	private EOContrat contrat;


	public NSArray<EOAffectation> lstAffectations() {
		Session sess = (Session) session();
		if (sess.lstAffectations() == null){
			sess.setLstAffectations(EOAffectation.affectationsValidesForIndividu(getEc(), getEditedIndividu()));
//			sess.setLstAffectations(FinderMangue.affectationsForIndividu(getEc(),
// 					getEditedIndividu()));
		}
		return sess.lstAffectations();
	}

	public NSArray<EOCarriere> lstCarrieres() {
		Session sess = (Session) session();
		if (sess.lstCarrieres() == null)
			sess.setLstCarrieres(EOCarriere.carrieresForIndividu(getEc(), getEditedIndividu()));
//			sess.setLstCarrieres(FinderMangue.carrieresForIndividu(getEc(),
//					getEditedIndividu()));
		return sess.lstCarrieres();
	}
	/**
	 * @return the lstContrats
	 */
	public NSArray<EOContrat> lstContrats() {
		Session sess = (Session) session();
		if (sess.lstContrats() == null)
			sess.setLstContrats(EOContrat.contratsForIndividu(getEc(), getEditedIndividu()));
//			sess.setLstContrats(FinderMangue.contratsForIndividu(getEc(),
//					getEditedIndividu()));		
		return sess.lstContrats();
	}
	
	/**
	 * @return the affectation
	 */
	public EOAffectation affectation() {
		return affectation;
	}
	/**
	 * @param contrat the contrat to set
	 */
	public void setContrat(EOContrat contrat) {
		this.contrat = contrat;
	}

	public EOContrat getContrat() {
		return contrat;
	}
	
	/**
	 * @param affectation the affectation to set
	 */
	public void setAffectation(EOAffectation affectation) {
		this.affectation = affectation;
	}

	/**
	 * @return the carriere
	 */
	public EOCarriere carriere() {
		return carriere;
	}

	/**
	 * @param carriere the carriere to set
	 */
	public void setCarriere(EOCarriere carriere) {
		this.carriere = carriere;
	}

	/**
	 * @return the element
	 */
	public EOElements element() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(EOElements element) {
		this.element = element;
	}
	
    public String backgroundColorForRow(){
                _rowFlip=!_rowFlip;
         if (_rowFlip) return "pair"; else return "impair";
     }
    
    /**
	 * @return the hasContrats
	 */
	public boolean hasContrats() {
		boolean ownedContrat = false;
		if (lstContrats().count() > 0){
			ownedContrat = true;
		}
		return ownedContrat;
	}
	
	/**
	 * @return the hasCarrieres
	 */
	public boolean hasCarrieres() {
		boolean ownedCarriere = false;
		if (lstCarrieres() .count() > 0){
			ownedCarriere = true;
		}
		return ownedCarriere;
	}
	
	/**
	 * @return the hasAffectations
	 */
	public boolean hasAffectations() {
		boolean ownedAffectation = false;
		if (lstCarrieres() .count() > 0){
			ownedAffectation = true;
		}
		return ownedAffectation;
	}
	
	public String getTimestampFormatter() {
		return DateCtrl.DEFAULT_FORMAT;
	}
}