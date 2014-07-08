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

import org.cocktail.fwkcktlajaxwebext.serveur.CocktailAjaxSession;
import org.cocktail.fwkcktlajaxwebext.serveur.component.CktlAjaxWindow;
import org.cocktail.fwkcktlgrh.common.metier.EOAffectation;
import org.cocktail.fwkcktlgrh.common.metier.EOCarriere;
import org.cocktail.fwkcktlgrh.common.metier.EOContrat;
import org.cocktail.fwkcktlgrh.common.metier.EOIndividuDiplome;
import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOEnfant;
import org.cocktail.fwkcktlpersonne.common.metier.EOEtudiant;
import org.cocktail.fwkcktlpersonne.common.metier.EOIcal;
import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EORib;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.profiler.server.eof.EOInscDipl;
import org.cocktail.profiler.server.eof.EOScolInscriptionEtudiant;
import org.cocktail.profiler.serveur.components.InfosPerso;
import org.cocktail.profiler.serveur.components.InfosPro;
import org.cocktail.profiler.serveur.finder.FinderEtatCivil;
import org.cocktail.profiler.serveur.finder.FinderMangue;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSArray;

public class Session extends CocktailAjaxSession {
	private static final long serialVersionUID = 1L;

	private ProfilerUser PUser;

	private String selectedOnglet;
	
	private IPersonne selectedPersonne;
	
	private NSArray<EOIcal> lstIcals;

	private NSArray<EOIndividuDiplome> lstDiplomes;

	private NSArray<EOEnfant> lstEnfants;

	private NSArray<EORib> lstRibs;

	private NSArray<EOAffectation> lstAffectations;

	private NSArray<EOCarriere> lstCarrieres;

	private NSArray<EOContrat> lstContrats;

	private EOIndividu detailsIndividu;

	private NSArray<EOScolInscriptionEtudiant> lstInsc;
	
    protected EOScolInscriptionEtudiant inscriptionSelected;
    
    private boolean wantReset = false;
    

	public String getSelectedOnglet() {

		return selectedOnglet;
	}

	public void setSelectedOnglet(String selectedOnglet) {

		this.selectedOnglet = selectedOnglet;
	}

	private String pageName;

	public Session() {
		setWindowsClassName(CktlAjaxWindow.WINDOWS_CLASS_NAME_GREYLIGHTING);
	}

	public ProfilerUser getPUser() {
		return PUser;
	}

	public void setPUser(ProfilerUser pUser) {
		PUser = pUser;
	}

	

	/**
	 * @return the selectedPersonne
	 */
	public IPersonne selectedPersonne() {
		return selectedPersonne;
	}

	/**
	 * @param selectedPersonne
	 *            the selectedPersonne to set
	 */
	public void setSelectedPersonne(IPersonne selectedPersonne) {
		this.selectedPersonne = selectedPersonne;
	}

	private EOCompte selectedCompte;

	public EOCompte getSelectedCompte() {
		return this.selectedCompte;
	}

	public void setSelectedCompte(EOCompte compte) {
		this.selectedCompte = compte;
	}

	private EOGenericRecord photo;

	public EOGenericRecord getPhoto() {
		return photo;
	}

	public void setPhoto(EOGenericRecord photo) {
		this.photo = photo;
	}

	
    
	/**
	 * @return the lstIcals
	 */
	public NSArray<EOIcal> lstIcals() {
		return lstIcals;
	}

	/**
	 * @param lstIcals
	 *            the lstIcals to set
	 */
	public void setLstIcals(NSArray<EOIcal> lstIcals) {
		this.lstIcals = lstIcals;
	}

	public void resetDatas() {

		setSelectedCompte(null);
		setPhoto(null);
		setLstIcals(null);
		setDetailsIndividu(null);
		setLstEnfants(null);
		setLstDiplomes(null);
		setLstRibs(null);
		setLstAffectations(null);
		setLstCarrieres(null);
		setLstContrats(null);
		displayInfosPro = null;
		lstInscDipl = null;
		lstInsc = null;
		inscriptionSelected = null;
		setWantReset(true);
	}
	
	
	

	public boolean isWantReset() {
		return wantReset;
	}

	public void setWantReset(boolean wantReset) {
		this.wantReset = wantReset;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public NSArray<EOIndividuDiplome> lstDiplomes() {
		return lstDiplomes;
	}

	public void setLstDiplomes(NSArray<EOIndividuDiplome> diplomesForIndividu) {
		lstDiplomes = diplomesForIndividu;

	}

	public NSArray<EOEnfant> lstEnfants() {
		return lstEnfants;
	}

	public void setLstEnfants(NSArray<EOEnfant> enfantsForIndividu) {
		lstEnfants = enfantsForIndividu;
	}

	public NSArray<EORib> lstRibs() {
		return lstRibs;
	}

	public void setLstRibs(NSArray<EORib> ribsForIndividu) {
		lstRibs = ribsForIndividu;
	}

	public NSArray<EOAffectation> lstAffectations() {
		return lstAffectations;
	}

	public void setLstAffectations(
			NSArray<EOAffectation> affectationsForIndividu) {
		lstAffectations = affectationsForIndividu;
	}

	public NSArray<EOCarriere> lstCarrieres() {
		return lstCarrieres;
	}

	public void setLstCarrieres(NSArray<EOCarriere> carrieresForIndividu) {
		lstCarrieres = carrieresForIndividu;
	}

	public NSArray<EOContrat> lstContrats() {
		return lstContrats;
	}

	public void setLstContrats(NSArray<EOContrat> contratsForIndividu) {
		lstContrats = contratsForIndividu;
	}

	public EOIndividu detailsIndividu() {
		return detailsIndividu;
	}

	public void setDetailsIndividu(EOIndividu detailsForIndividu) {
		detailsIndividu = detailsForIndividu;
	}

	private Boolean displayInfosPro;

	public boolean displayInfosPro() {
		if (displayInfosPro == null) {
			displayInfosPro = (selectedPersonne().isIndividu())
					&& !FinderMangue.affectationsForIndividu(
							defaultEditingContext(),
							((EOIndividu) selectedPersonne())).isEmpty();
		}
		if (!displayInfosPro
				&& InfosPro.class.getName().equals(getSelectedOnglet())) {
			setSelectedOnglet(InfosPerso.class.getName());
		}
		return displayInfosPro;
	}

	private NSArray<EOInscDipl> lstInscDipl;

	public NSArray<EOInscDipl> lstInscDipl(){
		if (lstInscDipl == null ) {
			if ((selectedPersonne()!=null)&&(selectedPersonne().isIndividu())){
			EOEtudiant etudiant = FinderEtatCivil.etudiantForIndividu(defaultEditingContext(),
					(EOIndividu) selectedPersonne());
			if (etudiant!=null)
				lstInscDipl = FinderEtatCivil.getInscDiplForEtudiant(defaultEditingContext(), etudiant);
			}
		}
		return lstInscDipl;
	}

	public NSArray<EOScolInscriptionEtudiant> listeInscription()
	{
		if (lstInsc == null ) {
			if ((((Session)session()).selectedPersonne()!=null)&&(((Session)session()).selectedPersonne().isIndividu())){
				EOEtudiant etudiant = FinderEtatCivil.etudiantForIndividu(defaultEditingContext(),
						(EOIndividu)((Session)session()).selectedPersonne());
				if (etudiant!=null)
					lstInsc = FinderEtatCivil.getScolInscriptionEtudiant(defaultEditingContext(), etudiant);
				if(lstInsc != null && lstInsc.count() > 0 && inscriptionSelected == null)
					setInscriptionSelected((EOScolInscriptionEtudiant)((Session)session()).listeInscription().objectAtIndex(0));
			}
		}
		return lstInsc;
	}

    public EOScolInscriptionEtudiant inscriptionSelected()
    {
        return inscriptionSelected;
    }

    public void setInscriptionSelected(EOScolInscriptionEtudiant newInscriptionSelected)
    {
    	inscriptionSelected = newInscriptionSelected;
    }

}
