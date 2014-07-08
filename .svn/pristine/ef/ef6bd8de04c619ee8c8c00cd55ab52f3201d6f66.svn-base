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
import org.cocktail.fwkcktlpersonne.common.metier.PersonneDelegate;
import org.cocktail.fwkcktlpersonneguiajax.serveur.components.AComponent;
import org.cocktail.profiler.serveur.ProfilPersonneDelegate;
import org.cocktail.profiler.serveur.ProfilerUser;
import org.cocktail.profiler.serveur.Session;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class ProfilBaseCmp extends AComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String BND_EDITED_PERSONNE = "editedPersonne";
	public static final String BND_EC = "ec";

	private EOEditingContext ec;

	public ProfilBaseCmp(WOContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private NSArray<String> lstEditZones;

	public NSArray<String> getLstEditZones() {
		return lstEditZones;
	}

	public void setLstEditZones(NSArray<String> lstEditZones) {
		this.lstEditZones = lstEditZones;
	}

	// private Boolean isNotEdited = Boolean.TRUE;

	// /**
	// * @return the isNotEdited
	// */
	// public Boolean isNotEdited() {
	// return isNotEdited;
	// }
	//
	// /**
	// * @param isNotEdited
	// * the isNotEdited to set
	// */
	// public void setNotEdited(Boolean isNotEdited) {
	// this.isNotEdited = isNotEdited;
	// }

	private Boolean cmpEditing = Boolean.FALSE;

	public Boolean getCmpEditing() {
		if (hasBinding("cmpEditing"))
			cmpEditing = (Boolean) valueForBinding("cmpEditing");

		return cmpEditing;
	}

	public void setCmpEditing(Boolean cmpEditing) {
		this.cmpEditing = cmpEditing;
		if (canSetValueForBinding("cmpEditing"))
			setValueForBinding(cmpEditing, "cmpEditing");

	}

	private IPersonne editedPersonne;

	/**
	 * @return the editedPersonne
	 */
	public IPersonne editedPersonne() {
		if (hasBinding(BND_EDITED_PERSONNE)) {
			setEditedPersonne((IPersonne) valueForBinding(BND_EDITED_PERSONNE));
		}
		if (editedPersonne == null) {
			if (((Session) session()).getPUser() != null) {
				setEditedPersonne(PersonneDelegate.fetchPersonneByPersId(
						getEc(), ((Session) session()).getPUser().getPersId()));
			}

		}

		return editedPersonne;
	}

	/**
	 * @param editedPersonne
	 *            the editedPersonne to set
	 */
	public void setEditedPersonne(IPersonne editedPersonne) {
		this.editedPersonne = editedPersonne;

		/*
		 * if ((editedPersonne != null) && (editedPersonne.isIndividu())) { if
		 * (!(((EOIndividu) editedPersonne).getPersonneDelegate() instanceof
		 * ProfilPersonneDelegate)) { ((EOIndividu) editedPersonne)
		 * .setPersonneDelegate(new ProfilPersonneDelegate( editedPersonne,
		 * ((Session) session()) .getPUser()));
		 * System.out.println((((EOIndividu) editedPersonne)
		 * .getPersonneDelegate())); } } //
		 */

		if (canSetValueForBinding(BND_EDITED_PERSONNE)) {
			// System.out.println("editpersonne hasbinding");
			setValueForBinding(editedPersonne, BND_EDITED_PERSONNE);
		}

	}

	public EOEditingContext getEc() {
		if (hasBinding(BND_EC)) {
			ec = (EOEditingContext) valueForBinding(BND_EC);
		}
		if (ec == null)
			ec = session().defaultEditingContext();
		return ec;
	}

	public void setEc(EOEditingContext ec) {
		this.ec = ec;
		if (canSetValueForBinding(BND_EC)) {
			setValueForBinding(ec, BND_EC);
		}
	}

	// public Boolean canCancelEdition() {
	// //System.out.println("canCancelEdition:" + (!isNotEdited &&
	// !cmpEditing));
	// return (!isNotEdited && !cmpEditing);
	// }

	public WOActionResults cancelEdit() {
		getEc().revert();
		return backFromEdition();
	}

	public WOActionResults backFromEdition() {
		setCmpEditing(Boolean.FALSE);
		// setNotEdited(Boolean.TRUE);
		return null;
	}

	/**
	 * le PUser fait la gestion des droits
	 * 
	 * @return ProfilerUser
	 */
	public ProfilerUser getPuser() {
		return ((Session) session()).getPUser();
	}

	/**
	 * methode a surcharger dans les class descendantes pour gestion des droits
	 * 
	 * @returns
	 */
	public boolean haveRight() {
		return true;
	}

	// public WOActionResults edit() {
	// if (haveRight())
	// setNotEdited(Boolean.FALSE);
	// return null;
	// }

	public WOActionResults save() throws Exception {

		// try {
		if (getEditedIndividu() != null) {
			if (!(getEditedIndividu().getPersonneDelegate() instanceof ProfilPersonneDelegate))
				getEditedIndividu().setPersonneDelegate(
						new ProfilPersonneDelegate(editedPersonne(),
								((Session) session()).getPUser()));
		}
		editedPersonne().willChange();
		edc().saveChanges();
		if (edc().parentObjectStore() instanceof EOEditingContext) {
			// System.out.println("   nested  " + edc().parentObjectStore());
			((EOEditingContext) edc().parentObjectStore()).saveChanges();
		}
		backFromEdition();
		/*
		 * } catch (Exception e) { e.printStackTrace(); throw e; } //
		 */
		return null;
	}

	public Boolean haveModifications() {

		return getEc().hasChanges();
	}

	public EOIndividu getEditedIndividu() {
		if (editedPersonne().isIndividu())
			return (EOIndividu) editedPersonne();
		return null;
		/*
		 * if (editedIndividu == null) editedIndividu =
		 * EOIndividu.fetchByKeyValue(getEc(), EOIndividu.PERS_ID_KEY,
		 * editedPersonne().persId()); if
		 * (!editedIndividu.persId().equals(editedPersonne().persId()))
		 * editedIndividu = EOIndividu.fetchByKeyValue(getEc(),
		 * EOIndividu.PERS_ID_KEY, editedPersonne().persId()); return
		 * editedIndividu; //
		 */
	}

}
