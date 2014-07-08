// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolFormationGrade.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolFormationGrade extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationGrade";

	// Attributes
	public static final String FGRA_ABREVIATION_KEY = "fgraAbreviation";
	public static final String FGRA_CODAGE_KEY = "fgraCodage";
	public static final String FGRA_CODE_KEY = "fgraCode";
	public static final String FGRA_LIBELLE_KEY = "fgraLibelle";
	public static final String FGRA_VALIDITE_KEY = "fgraValidite";

	// Relationships
	public static final String TO_SCOL_FORMATION_DIPLOMES_KEY = "toScolFormationDiplomes";

  private static Logger LOG = Logger.getLogger(_EOScolFormationGrade.class);

  public EOScolFormationGrade localInstanceIn(EOEditingContext editingContext) {
    EOScolFormationGrade localInstance = (EOScolFormationGrade)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String fgraAbreviation() {
    return (String) storedValueForKey("fgraAbreviation");
  }

  public void setFgraAbreviation(String value) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
    	_EOScolFormationGrade.LOG.debug( "updating fgraAbreviation from " + fgraAbreviation() + " to " + value);
    }
    takeStoredValueForKey(value, "fgraAbreviation");
  }

  public String fgraCodage() {
    return (String) storedValueForKey("fgraCodage");
  }

  public void setFgraCodage(String value) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
    	_EOScolFormationGrade.LOG.debug( "updating fgraCodage from " + fgraCodage() + " to " + value);
    }
    takeStoredValueForKey(value, "fgraCodage");
  }

  public String fgraCode() {
    return (String) storedValueForKey("fgraCode");
  }

  public void setFgraCode(String value) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
    	_EOScolFormationGrade.LOG.debug( "updating fgraCode from " + fgraCode() + " to " + value);
    }
    takeStoredValueForKey(value, "fgraCode");
  }

  public String fgraLibelle() {
    return (String) storedValueForKey("fgraLibelle");
  }

  public void setFgraLibelle(String value) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
    	_EOScolFormationGrade.LOG.debug( "updating fgraLibelle from " + fgraLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, "fgraLibelle");
  }

  public String fgraValidite() {
    return (String) storedValueForKey("fgraValidite");
  }

  public void setFgraValidite(String value) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
    	_EOScolFormationGrade.LOG.debug( "updating fgraValidite from " + fgraValidite() + " to " + value);
    }
    takeStoredValueForKey(value, "fgraValidite");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome> toScolFormationDiplomes() {
    return (NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome>)storedValueForKey("toScolFormationDiplomes");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome> toScolFormationDiplomes(EOQualifier qualifier) {
    return toScolFormationDiplomes(qualifier, null, false);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome> toScolFormationDiplomes(EOQualifier qualifier, boolean fetch) {
    return toScolFormationDiplomes(qualifier, null, fetch);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome> toScolFormationDiplomes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolFormationDiplome.TO_SCOL_FORMATION_GRADE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.profiler.server.eof.EOScolFormationDiplome.fetchScolFormationDiplomes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toScolFormationDiplomes();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolFormationDiplome>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToScolFormationDiplomesRelationship(org.cocktail.profiler.server.eof.EOScolFormationDiplome object) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
      _EOScolFormationGrade.LOG.debug("adding " + object + " to toScolFormationDiplomes relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "toScolFormationDiplomes");
  }

  public void removeFromToScolFormationDiplomesRelationship(org.cocktail.profiler.server.eof.EOScolFormationDiplome object) {
    if (_EOScolFormationGrade.LOG.isDebugEnabled()) {
      _EOScolFormationGrade.LOG.debug("removing " + object + " from toScolFormationDiplomes relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toScolFormationDiplomes");
  }

  public org.cocktail.profiler.server.eof.EOScolFormationDiplome createToScolFormationDiplomesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolFormationDiplome");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "toScolFormationDiplomes");
    return (org.cocktail.profiler.server.eof.EOScolFormationDiplome) eo;
  }

  public void deleteToScolFormationDiplomesRelationship(org.cocktail.profiler.server.eof.EOScolFormationDiplome object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toScolFormationDiplomes");
    editingContext().deleteObject(object);
  }

  public void deleteAllToScolFormationDiplomesRelationships() {
    Enumeration objects = toScolFormationDiplomes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToScolFormationDiplomesRelationship((org.cocktail.profiler.server.eof.EOScolFormationDiplome)objects.nextElement());
    }
  }


  public static EOScolFormationGrade createScolFormationGrade(EOEditingContext editingContext, String fgraCode
, String fgraLibelle
, String fgraValidite
) {
    EOScolFormationGrade eo = (EOScolFormationGrade) EOUtilities.createAndInsertInstance(editingContext, _EOScolFormationGrade.ENTITY_NAME);    
		eo.setFgraCode(fgraCode);
		eo.setFgraLibelle(fgraLibelle);
		eo.setFgraValidite(fgraValidite);
    return eo;
  }

  public static NSArray<EOScolFormationGrade> fetchAllScolFormationGrades(EOEditingContext editingContext) {
    return _EOScolFormationGrade.fetchAllScolFormationGrades(editingContext, null);
  }

  public static NSArray<EOScolFormationGrade> fetchAllScolFormationGrades(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolFormationGrade.fetchScolFormationGrades(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolFormationGrade> fetchScolFormationGrades(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolFormationGrade.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolFormationGrade> eoObjects = (NSArray<EOScolFormationGrade>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolFormationGrade fetchScolFormationGrade(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationGrade.fetchScolFormationGrade(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationGrade fetchScolFormationGrade(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolFormationGrade> eoObjects = _EOScolFormationGrade.fetchScolFormationGrades(editingContext, qualifier, null);
    EOScolFormationGrade eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolFormationGrade)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationGrade that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationGrade fetchRequiredScolFormationGrade(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationGrade.fetchRequiredScolFormationGrade(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationGrade fetchRequiredScolFormationGrade(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolFormationGrade eoObject = _EOScolFormationGrade.fetchScolFormationGrade(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationGrade that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationGrade localInstanceIn(EOEditingContext editingContext, EOScolFormationGrade eo) {
    EOScolFormationGrade localInstance = (eo == null) ? null : (EOScolFormationGrade)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
