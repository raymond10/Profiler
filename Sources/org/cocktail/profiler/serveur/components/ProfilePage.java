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

import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerUser;
import org.cocktail.profiler.serveur.Session;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;

import er.ajax.AjaxModalDialog;

public class ProfilePage extends ProfilBaseCmp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfilePage(WOContext context) {
		super(context);

	}
	
	@Override
	public void appendToResponse(WOResponse woresponse, WOContext wocontext) {
		if (((Session) session()).isWantReset()) {
			((Session) session()).setWantReset(false);
		}
		super.appendToResponse(woresponse, wocontext);
	}

	public WOActionResults doNothing() {
		return null;
	}

	public String classInfosPerso() {
		if (InfosPerso.class.getName().equals(
				((Session) session()).getSelectedOnglet()))
			return "selectedTab";
		return "";
	}

	public WOActionResults goInfosPro() {
		((Session) session()).setSelectedOnglet(InfosPro.class.getName());
		return null;
	}

	public String classEtatCivil() {
		if (EtatCivil.class.getName().equals(
				((Session) session()).getSelectedOnglet()))
			return "selectedTab";
		return "";
	}

	public WOActionResults goEtatCivil() {
		((Session) session()).setSelectedOnglet(EtatCivil.class.getName());
		return null;
	}

	public WOActionResults goInfosScol() {
		((Session) session()).setSelectedOnglet(Scolarite.class.getName());
		return null;
	}

	public String classInfosPro() {
		if (InfosPro.class.getName().equals(
				((Session) session()).getSelectedOnglet()))
			return "selectedTab";
		return "";
	}

	public String classInfosScol() {
		if (Scolarite.class.getName().equals(
				((Session) session()).getSelectedOnglet()))
			return "selectedTab";
		return "";
	}

	public WOActionResults goInfosPerso() {
		((Session) session()).setSelectedOnglet(InfosPerso.class.getName());
		return null;
	}

	public String classCompte() {
		if (InfosCompte.class.getName().equals(
				((Session) session()).getSelectedOnglet()))
			return "selectedTab";
		return "";
	}

	public WOActionResults goCompte() {
		((Session) session()).setSelectedOnglet(InfosCompte.class.getName());
		return null;
	}

	public WOActionResults selectFromSearch() {
		((Session) session()).setSelectedPersonne(selectedSearchPersonne());
		((Session) session()).resetDatas();
		return null;
	}

	public ProfilerUser getPUser() {
		return ((Session) session()).getPUser();
	}

	private String searchTypeIntExt = "interne";

	/**
	 * @return the searchTypeIntExt
	 */
	public String searchTypeIntExt() {
		return searchTypeIntExt;
	}

	/**
	 * @param searchTypeIntExt
	 *            the searchTypeIntExt to set
	 */
	public void setSearchTypeIntExt(String searchTypeIntExt) {
		this.searchTypeIntExt = searchTypeIntExt;
	}

	private String searchTypePhysMoral = "individu";

	/**
	 * @return the searchTypePhysMoral
	 */
	public String searchTypePhysMoral() {
		return searchTypePhysMoral;
	}

	/**
	 * @param searchTypePhysMoral
	 *            the searchTypePhysMoral to set
	 */
	public void setSearchTypePhysMoral(String searchTypePhysMoral) {
		this.searchTypePhysMoral = searchTypePhysMoral;
	}

	public WOActionResults openSearch() {
		//CktlAjaxWindow.open(context(), "amdSearch", "Recherche ...");
//		edc().invalidateAllObjects();
		getEc().invalidateAllObjects();
		AjaxModalDialog.open(context(), "amdSearch", "Recherche ...");
		setInSearch(true);
		return null;
	}

	public WOActionResults onCloseSearch() {
		setInSearch(false);

		return null;
	}

	private boolean isInSearch;

	/**
	 * @return the isInSearch
	 */
	public boolean isInSearch() {
		return isInSearch;
	}

	/**
	 * @param isInSearch
	 *            the isInSearch to set
	 */
	public void setInSearch(boolean isInSearch) {
		this.isInSearch = isInSearch;
	}

	public String aucTriggerSearchId() {

		return getComponentId() + "_aucTriggerSearchId";
	}

	private NSArray<String> lstRefreshSearchZones = new NSArray<String>(
			new String[] { "aucSearch" });

	/**
	 * @return the lstRefreshSearchZones
	 */
	public NSArray<String> lstRefreshSearchZones() {
		return lstRefreshSearchZones;
	}

	/**
	 * @param lstRefreshSearchZones
	 *            the lstRefreshSearchZones to set
	 */
	public void setLstRefreshSearchZones(NSArray<String> lstRefreshSearchZones) {
		this.lstRefreshSearchZones = lstRefreshSearchZones;
	}

	public String aucselpersonneid() {
		return getComponentId() + "_aucselpersonneid";
	}

	private IPersonne selectedSearchPersonne;

	/**
	 * @return the selectedSearchPersonne
	 */
	public IPersonne selectedSearchPersonne() {
		return selectedSearchPersonne;
	}

	/**
	 * @param selectedSearchPersonne
	 *            the selectedSearchPersonne to set
	 */
	public void setSelectedSearchPersonne(IPersonne selectedSearchPersonne) {
		this.selectedSearchPersonne = selectedSearchPersonne;
	}

	public boolean canShowScol() {
		return ((Application) application()).config().booleanForKey(
				Application.SHOW_SCOL)
				&& ( ((EOIndividu) ((Session) session()).selectedPersonne()).isEtudiant() )
				&& (((Session) session()).lstInscDipl() != null)
				&& (((Session) session()).lstInscDipl().size() > 0);

	}

}