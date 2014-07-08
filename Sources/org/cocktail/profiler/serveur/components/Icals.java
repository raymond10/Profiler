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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.UUID;

import org.cocktail.fwkcktlpersonne.common.metier.EOIcal;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.UtilMessages;
import org.cocktail.profiler.serveur.finder.FinderIcals;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXStringUtilities;

/**
 * 
 * @author alainmalaplate
 * Depuis le 27/07/11 utilisez plutôt le composant IndividuICalUI du FrwkCktlPersonneGUIAjax
 * 
 */
@Deprecated
public class Icals extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String erreurContainerid = ERXStringUtilities
			.safeIdentifierName("erreurContainerid" + UUID.randomUUID());

	private String messageid = ERXStringUtilities
			.safeIdentifierName("messageid" + UUID.randomUUID());

	public Icals(WOContext context) {
		super(context);
		setLstRefreshZones(new NSArray<String>(new String[] {
				erreurContainerid, icalsId, btbId }));
		lstDeletedObjects = new NSMutableArray<EOIcal>();
	}

	private NSArray<String> lstRefreshZones;

	private String saveOk;

	/**
	 * @return the lstRefreshZones
	 */
	public NSArray<String> lstRefreshZones() {
		return lstRefreshZones;
	}

	/**
	 * @param lstRefreshZones
	 *            the lstRefreshZones to set
	 */
	public void setLstRefreshZones(NSArray<String> lstRefreshZones) {
		this.lstRefreshZones = lstRefreshZones;
	}

	private EOIcal icalOccur;

	private EOIcal editedIcal;

	/**
	 * @return the icalOccur
	 */
	public EOIcal icalOccur() {
		return icalOccur;
	}

	/**
	 * @param icalOccur
	 *            the icalOccur to set
	 */
	public void setIcalOccur(EOIcal icalOccur) {
		this.icalOccur = icalOccur;
	}

	public NSArray<EOIcal> lstIcals() {
		Session sess = (Session) session();
		if (sess.lstIcals() == null)
			sess.setLstIcals(FinderIcals.icalsForIndividu(getEc(),
					getEditedIndividu()));
		return sess.lstIcals();
	}

	public boolean canEditIcals() {

		return getPuser().canEditIcals(editedPersonne());
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return ((lstDeletedObjects() != null) && (lstDeletedObjects()
				.contains(icalOccur())));
	}

	private NSMutableArray<EOIcal> lstDeletedObjects;

	public NSMutableArray<EOIcal> lstDeletedObjects() {
		return lstDeletedObjects;
	}

	public void setLstDeletedObjects(NSMutableArray<EOIcal> lst) {
		lstDeletedObjects = lst;
	}

	public WOActionResults restore() {
		lstDeletedObjects().removeObject(icalOccur());
		return null;
	}

	private String icalsId = ERXStringUtilities.safeIdentifierName("icalsId"
			+ UUID.randomUUID());

	/**
	 * @return the icalsId
	 */
	public String icalsId() {
		return icalsId;
	}

	/**
	 * @param icalsId
	 *            the icalsId to set
	 */
	public void setIcalsId(String icalsId) {
		this.icalsId = icalsId;
	}

	private String editIcalId = ERXStringUtilities
			.safeIdentifierName("editIcalId" + UUID.randomUUID());

	/**
	 * @return the editIcalId
	 */
	public String editIcalId() {
		return editIcalId;
	}

	/**
	 * @param editIcalId
	 *            the editIcalId to set
	 */
	public void setEditIcalId(String editIcalId) {
		this.editIcalId = editIcalId;
	}

	public WOActionResults delete() {
		lstDeletedObjects().addObject(icalOccur());
		return null;
	}

	public String onEditIcals() {

		return "function (open) {openAMD_" + editIcalId + "();}";
	}

	private String aucTriggerIcalId = ERXStringUtilities
			.safeIdentifierName("aucTriggerIcalId" + UUID.randomUUID());

	/**
	 * @return the aucTriggerIcalId
	 */
	public String aucTriggerIcalId() {
		return aucTriggerIcalId;
	}

	/**
	 * @param aucTriggerIcalId
	 *            the aucTriggerIcalId to set
	 */
	public void setAucTriggerIcalId(String aucTriggerIcalId) {
		this.aucTriggerIcalId = aucTriggerIcalId;
	}

	public String getErreurContainerid() {
		return erreurContainerid;
	}

	public void setErreurContainerid(String erreurContainerid) {
		this.erreurContainerid = erreurContainerid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String scriptCloseDialog() {

		return "if ((!$('" + messageid + "').visible())&&(" + saveOk
				+ "==true)) {Modalbox.hide(); }";
	}

	public boolean isSavInProgress = false;

	public WOActionResults valide() {
		if (isSavInProgress)
			return null;
		isSavInProgress = true;

		saveOk = "false";
		if ((editedIcal.icalName() == null)
				|| ("".equals(editedIcal.icalName()))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Le fichier est obligatoire !!");

			isSavInProgress = false;
			return null;
		}
		if ((editedIcal.icalLien() == null)
				|| ("".equals(editedIcal.icalLien()))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"Le chemin est obligatoire !!");

			isSavInProgress = false;
			return null;
		}

		editedIcal.setDModification(new NSTimestamp());
		if (editedIcal.editingContext() == null)
			getEc().insertObject(editedIcal);

		try {
			editedIcal.editingContext().saveChanges();
		} catch (Exception e) {
			e.printStackTrace();
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Erreur lors de l'enregistrement de l'agenda:\n"
							+ e.getMessage());
			isSavInProgress = false;
			return null;
		}
		saveOk = "true";
		((Session) session()).setLstIcals(null);
		isSavInProgress = false;
		return null;
	}

	public WOActionResults cancelChange() {
		if (editedIcal.editingContext() != null)
			editedIcal.editingContext().revert();
		return null;
	}

	public EOIcal getEditedIcal() {
		return editedIcal;
	}

	public void setEditedIcal(EOIcal editedIcal) {
		this.editedIcal = editedIcal;
	}

	public WOActionResults editIcal() {
		setEditedIcal(icalOccur);
		saveOk="false";
		return null;
	}

	/**
	 * @return the classRow
	 */
	public String classRow() {
		return ((isDeleted()) ? "td deleted" : "td");
	}

	public WOActionResults addIcal() {
		EOIcal newIcal = new EOIcal();
		newIcal.setDCreation(new NSTimestamp());
		newIcal.setToIndividuRelationship(getEditedIndividu());
		newIcal.setIcalType("PRO");
		setEditedIcal(newIcal);
		saveOk="false";
		return null;
	}

	private String btbId = ERXStringUtilities.safeIdentifierName("btbId"
			+ UUID.randomUUID());

	/**
	 * @return the btbId
	 */
	public String btbId() {
		return btbId;
	}

	/**
	 * @param btbId
	 *            the btbId to set
	 */
	public void setBtbId(String btbId) {
		this.btbId = btbId;
	}

	public WOActionResults saveDelete() {
		// del des objets supprimés
		Enumeration<EOIcal> enumDel = lstDeletedObjects.objectEnumerator();
		while (enumDel.hasMoreElements()) {
			EOIcal ical = (EOIcal) enumDel.nextElement();
			getEc().deleteObject(ical);

		}
		lstDeletedObjects.removeAllObjects();

		getEc().saveChanges();
		((Session) session()).setLstIcals(null);
		return null;
	}

	public WOActionResults cancelDelete() {
		lstDeletedObjects.removeAllObjects();
		return null;
	}

	public boolean haveChanges() {
		return lstDeletedObjects.size()>0;
	}

	public String urlIcal() {		
		return icalOccur().icalLien()+icalOccur().icalName();
	}

	public String urlIcalEncoded() throws UnsupportedEncodingException {	
		//System.out.println(URLEncoder.encode(icalOccur().icalLien()+icalOccur().icalName(),"UTF-8"));
		return URLEncoder.encode(icalOccur().icalLien()+icalOccur().icalName(),"UTF-8");
	}
}