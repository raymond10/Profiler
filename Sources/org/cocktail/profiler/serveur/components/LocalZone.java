package org.cocktail.profiler.serveur.components;

import java.util.UUID;

import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.profiler.serveur.ProfilerParamManager;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.foundation.ERXStringUtilities;

@SuppressWarnings("all")
public class LocalZone extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3860266378387935644L;
	private String aucBureauId = ERXStringUtilities
			.safeIdentifierName("aucBureau" + UUID.randomUUID());

	public LocalZone(WOContext context) {
		super(context);
	}

	/**
	 * @return the aucBureauId
	 */
	public String getAucBureauId() {
		return aucBureauId;
	}

	/**
	 * @param aucBureauId
	 *            the aucBureauId to set
	 */
	public void setAucBureauId(String aucBureauId) {
		this.aucBureauId = aucBureauId;
	}

	@Override
	public WOActionResults save() throws Exception {
		super.save();
		getEc().invalidateAllObjects();
		return null;
	}

	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que les
	 * localisation soient seulement en mode affichage.
	 */
	public boolean isBureauReadOnlyEnabled() {
		if (myApp().config().booleanForKey(
				ProfilerParamManager.PROFILER_BUREAU_READONLY_ACTIVE)) {
			return true;
		}
		return false;
	}

	public Boolean peutEditerPersonneLocalisation() {
		return Boolean.valueOf(getPuser().haveAdminRight());
	}

	// Ajout pour raffraîchissement du bureau en mode admin
	
	private boolean wantResetBureaux = false;
	public static String BINDING_EDITING_CONTEXT = "editingContext";
	public static final String BDG_personne = "personne";

	private EOEditingContext editingContext;
	private IPersonne personne;

	public boolean isWantResetBureaux() {
		return wantResetBureaux;
	}

	public void setWantResetBureaux(boolean wantResetBureaux) {
		this.wantResetBureaux = wantResetBureaux;
	}

	/**
	 * @return the personne
	 */
	public IPersonne personne() {
		setWantResetBureaux(true);
		return (IPersonne) valueForBinding(BDG_personne);
	}

	/**
	 * @param personne
	 *            the personne to set
	 */
	public void setPersonne(IPersonne personne) {
		this.personne = personne;
		setWantResetBureaux(true);
		setValueForBinding(personne, BDG_personne);
	}

	public EOEditingContext editingContext() {
		return (EOEditingContext) valueForBinding(BINDING_EDITING_CONTEXT);
	}

	/**
	 * @param editingContext
	 *            the editingContext to set
	 */
	public void setEditingContext(EOEditingContext editingContext) {
		this.editingContext = editingContext;
	}
}