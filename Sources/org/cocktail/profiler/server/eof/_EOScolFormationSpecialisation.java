// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolFormationSpecialisation.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolFormationSpecialisation extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationSpecialisation";

	// Attributes
	public static final String FSPN_ABREVIATION_KEY = "fspnAbreviation";
	public static final String FSPN_KEY_KEY = "fspnKey";
	public static final String FSPN_LIBELLE_KEY = "fspnLibelle";

	// Relationships
	public static final String TO_INSC_DIPLS_KEY = "toInscDipls";
	public static final String TO_SCOL_FORMATION_DIPLOME_KEY = "toScolFormationDiplome";

  private static Logger LOG = Logger.getLogger(_EOScolFormationSpecialisation.class);

  public EOScolFormationSpecialisation localInstanceIn(EOEditingContext editingContext) {
    EOScolFormationSpecialisation localInstance = (EOScolFormationSpecialisation)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String fspnAbreviation() {
    return (String) storedValueForKey("fspnAbreviation");
  }

  public void setFspnAbreviation(String value) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
    	_EOScolFormationSpecialisation.LOG.debug( "updating fspnAbreviation from " + fspnAbreviation() + " to " + value);
    }
    takeStoredValueForKey(value, "fspnAbreviation");
  }

  public Integer fspnKey() {
    return (Integer) storedValueForKey("fspnKey");
  }

  public void setFspnKey(Integer value) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
    	_EOScolFormationSpecialisation.LOG.debug( "updating fspnKey from " + fspnKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fspnKey");
  }

  public String fspnLibelle() {
    return (String) storedValueForKey("fspnLibelle");
  }

  public void setFspnLibelle(String value) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
    	_EOScolFormationSpecialisation.LOG.debug( "updating fspnLibelle from " + fspnLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, "fspnLibelle");
  }

  public org.cocktail.profiler.server.eof.EOScolFormationDiplome toScolFormationDiplome() {
    return (org.cocktail.profiler.server.eof.EOScolFormationDiplome)storedValueForKey("toScolFormationDiplome");
  }

  public void setToScolFormationDiplomeRelationship(org.cocktail.profiler.server.eof.EOScolFormationDiplome value) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
      _EOScolFormationSpecialisation.LOG.debug("updating toScolFormationDiplome from " + toScolFormationDiplome() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolFormationDiplome oldValue = toScolFormationDiplome();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toScolFormationDiplome");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toScolFormationDiplome");
    }
  }
  
  public NSArray<org.cocktail.profiler.server.eof.EOInscDipl> toInscDipls() {
    return (NSArray<org.cocktail.profiler.server.eof.EOInscDipl>)storedValueForKey("toInscDipls");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOInscDipl> toInscDipls(EOQualifier qualifier) {
    return toInscDipls(qualifier, null, false);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOInscDipl> toInscDipls(EOQualifier qualifier, boolean fetch) {
    return toInscDipls(qualifier, null, fetch);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOInscDipl> toInscDipls(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.cocktail.profiler.server.eof.EOInscDipl> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOInscDipl.TO_SCOL_FORMATION_SPECIALISATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.profiler.server.eof.EOInscDipl.fetchInscDipls(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toInscDipls();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOInscDipl>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOInscDipl>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToInscDiplsRelationship(org.cocktail.profiler.server.eof.EOInscDipl object) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
      _EOScolFormationSpecialisation.LOG.debug("adding " + object + " to toInscDipls relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "toInscDipls");
  }

  public void removeFromToInscDiplsRelationship(org.cocktail.profiler.server.eof.EOInscDipl object) {
    if (_EOScolFormationSpecialisation.LOG.isDebugEnabled()) {
      _EOScolFormationSpecialisation.LOG.debug("removing " + object + " from toInscDipls relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toInscDipls");
  }

  public org.cocktail.profiler.server.eof.EOInscDipl createToInscDiplsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("InscDipl");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "toInscDipls");
    return (org.cocktail.profiler.server.eof.EOInscDipl) eo;
  }

  public void deleteToInscDiplsRelationship(org.cocktail.profiler.server.eof.EOInscDipl object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toInscDipls");
    editingContext().deleteObject(object);
  }

  public void deleteAllToInscDiplsRelationships() {
    Enumeration objects = toInscDipls().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToInscDiplsRelationship((org.cocktail.profiler.server.eof.EOInscDipl)objects.nextElement());
    }
  }


  public static EOScolFormationSpecialisation createScolFormationSpecialisation(EOEditingContext editingContext, Integer fspnKey
, org.cocktail.profiler.server.eof.EOScolFormationDiplome toScolFormationDiplome) {
    EOScolFormationSpecialisation eo = (EOScolFormationSpecialisation) EOUtilities.createAndInsertInstance(editingContext, _EOScolFormationSpecialisation.ENTITY_NAME);    
		eo.setFspnKey(fspnKey);
    eo.setToScolFormationDiplomeRelationship(toScolFormationDiplome);
    return eo;
  }

  public static NSArray<EOScolFormationSpecialisation> fetchAllScolFormationSpecialisations(EOEditingContext editingContext) {
    return _EOScolFormationSpecialisation.fetchAllScolFormationSpecialisations(editingContext, null);
  }

  public static NSArray<EOScolFormationSpecialisation> fetchAllScolFormationSpecialisations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolFormationSpecialisation.fetchScolFormationSpecialisations(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolFormationSpecialisation> fetchScolFormationSpecialisations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolFormationSpecialisation.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolFormationSpecialisation> eoObjects = (NSArray<EOScolFormationSpecialisation>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolFormationSpecialisation fetchScolFormationSpecialisation(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationSpecialisation.fetchScolFormationSpecialisation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationSpecialisation fetchScolFormationSpecialisation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolFormationSpecialisation> eoObjects = _EOScolFormationSpecialisation.fetchScolFormationSpecialisations(editingContext, qualifier, null);
    EOScolFormationSpecialisation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolFormationSpecialisation)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationSpecialisation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationSpecialisation fetchRequiredScolFormationSpecialisation(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationSpecialisation.fetchRequiredScolFormationSpecialisation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationSpecialisation fetchRequiredScolFormationSpecialisation(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolFormationSpecialisation eoObject = _EOScolFormationSpecialisation.fetchScolFormationSpecialisation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationSpecialisation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationSpecialisation localInstanceIn(EOEditingContext editingContext, EOScolFormationSpecialisation eo) {
    EOScolFormationSpecialisation localInstance = (eo == null) ? null : (EOScolFormationSpecialisation)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
