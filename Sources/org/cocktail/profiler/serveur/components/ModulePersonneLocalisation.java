package org.cocktail.profiler.serveur.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEditingContext;

import org.cocktail.fwkcktlpersonne.common.metier.IPersonne;
import org.cocktail.fwkgspot.serveur.metier.eof.EOTypeOccupation;
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.profiler.serveur.components.ProfilBaseCmp;

@SuppressWarnings("all")
public class ModulePersonneLocalisation extends ProfilBaseCmp {
    
	private static final long serialVersionUID = 7928198279382826811L;
    private Boolean hasGspotTables;
    private static final String WANT_RESET = "wantReset";
    //Ajout RN
    private static final String READONLY = "readOnly";
    public static final String BDG_personne = "personne";
    public static String BINDING_EDITING_CONTEXT = "editingContext";
    
	private IPersonne personne;
    private EOEditingContext editingContext;
    //

    public ModulePersonneLocalisation(WOContext context) {
        super(context);
    }
    
    
    @Override
	public void appendToResponse(WOResponse woresponse, WOContext wocontext) {
		if (wantReset()) {
			hasGspotTables = null;
//			setWantReset(Boolean.FALSE);
		}
		super.appendToResponse(woresponse, wocontext);
	}
    
    /**
     * @return true si les tables de Gspot sont présentes.
     *          Il faut voir si à la place, on ne peut pas carrément forcer 
     *          une vérif de dépendance au démarrage via les versions de bdd...
     */
    public Boolean hasGspotTables() {
        if (hasGspotTables == null) {
            try {
                EOTypeOccupation.fetchAllFwkGspot_TypeOccupations(getEc());
                hasGspotTables = Boolean.TRUE;
            } catch (Exception e) {
                hasGspotTables = Boolean.FALSE;
                //logger().error(e.getMessage(), e);
            }
        }
        return hasGspotTables;
    }
    
    public boolean wantReset() {
    	return (Boolean) valueForBinding(WANT_RESET);
	}

	public void setWantReset(Boolean value) {
		setValueForBinding(value, WANT_RESET);
	}
	
	public boolean readOnly() {
		boolean value = (Boolean) valueForBinding(READONLY);
    	return value;
	}

	public void setIsReadOnly(Boolean value) {
		setValueForBinding(value, READONLY);
	}
    
	//modif RN
	public Boolean peutEditerPersonneLocalisation() {
		//getPuser().getPersId().equals(editedPersonne().persId()) || 
		return getPuser().getPersId().equals(editedPersonne().persId()) || getPuser().haveAdminRight();
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
	
	//Ajout RN
	/**
	 * @return the personne
	 */
	public IPersonne personne() {
		setWantReset(true);
		return (IPersonne) valueForBinding(BDG_personne);
	}

	/**
	 * @param personne
	 *            the personne to set
	 */
	public void setPersonne(IPersonne personne) {
		this.personne = personne;
		setWantReset(true);
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
	//
}