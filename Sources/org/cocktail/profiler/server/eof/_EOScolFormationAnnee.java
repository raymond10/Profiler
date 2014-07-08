// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolFormationAnnee.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolFormationAnnee extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationAnnee";

	// Attributes
	public static final String FANN_COURANTE_KEY = "fannCourante";
	public static final String FANN_DEBUT_KEY = "fannDebut";
	public static final String FANN_FIN_KEY = "fannFin";
	public static final String FANN_KEY_KEY = "fannKey";

	// Relationships
	public static final String SCOL_EXAMEN_ENTETES_KEY = "scolExamenEntetes";
	public static final String SCOL_MAQUETTE_EC_LIBRES_KEY = "scolMaquetteEcLibres";
	public static final String SCOL_MAQUETTE_ECS_KEY = "scolMaquetteEcs";

  private static Logger LOG = Logger.getLogger(_EOScolFormationAnnee.class);

  public EOScolFormationAnnee localInstanceIn(EOEditingContext editingContext) {
    EOScolFormationAnnee localInstance = (EOScolFormationAnnee)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String fannCourante() {
    return (String) storedValueForKey("fannCourante");
  }

  public void setFannCourante(String value) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
    	_EOScolFormationAnnee.LOG.debug( "updating fannCourante from " + fannCourante() + " to " + value);
    }
    takeStoredValueForKey(value, "fannCourante");
  }

  public Long fannDebut() {
    return (Long) storedValueForKey("fannDebut");
  }

  public void setFannDebut(Long value) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
    	_EOScolFormationAnnee.LOG.debug( "updating fannDebut from " + fannDebut() + " to " + value);
    }
    takeStoredValueForKey(value, "fannDebut");
  }

  public Long fannFin() {
    return (Long) storedValueForKey("fannFin");
  }

  public void setFannFin(Long value) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
    	_EOScolFormationAnnee.LOG.debug( "updating fannFin from " + fannFin() + " to " + value);
    }
    takeStoredValueForKey(value, "fannFin");
  }

  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
    	_EOScolFormationAnnee.LOG.debug( "updating fannKey from " + fannKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fannKey");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete> scolExamenEntetes() {
    return (NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete>)storedValueForKey("scolExamenEntetes");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete> scolExamenEntetes(EOQualifier qualifier) {
    return scolExamenEntetes(qualifier, null, false);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete> scolExamenEntetes(EOQualifier qualifier, boolean fetch) {
    return scolExamenEntetes(qualifier, null, fetch);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete> scolExamenEntetes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolExamenEntete.SCOL_FORMATION_ANNEE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.profiler.server.eof.EOScolExamenEntete.fetchScolExamenEntetes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolExamenEntetes();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolExamenEntete>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolExamenEntetesRelationship(org.cocktail.profiler.server.eof.EOScolExamenEntete object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("adding " + object + " to scolExamenEntetes relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolExamenEntetes");
  }

  public void removeFromScolExamenEntetesRelationship(org.cocktail.profiler.server.eof.EOScolExamenEntete object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("removing " + object + " from scolExamenEntetes relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolExamenEntetes");
  }

  public org.cocktail.profiler.server.eof.EOScolExamenEntete createScolExamenEntetesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolExamenEntete");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolExamenEntetes");
    return (org.cocktail.profiler.server.eof.EOScolExamenEntete) eo;
  }

  public void deleteScolExamenEntetesRelationship(org.cocktail.profiler.server.eof.EOScolExamenEntete object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolExamenEntetes");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolExamenEntetesRelationships() {
    Enumeration objects = scolExamenEntetes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolExamenEntetesRelationship((org.cocktail.profiler.server.eof.EOScolExamenEntete)objects.nextElement());
    }
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre> scolMaquetteEcLibres() {
    return (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre>)storedValueForKey("scolMaquetteEcLibres");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre> scolMaquetteEcLibres(EOQualifier qualifier) {
    return scolMaquetteEcLibres(qualifier, null, false);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre> scolMaquetteEcLibres(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteEcLibres(qualifier, null, fetch);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre> scolMaquetteEcLibres(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre.SCOL_FORMATION_ANNEE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre.fetchScolMaquetteEcLibres(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteEcLibres();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteEcLibresRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("adding " + object + " to scolMaquetteEcLibres relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteEcLibres");
  }

  public void removeFromScolMaquetteEcLibresRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("removing " + object + " from scolMaquetteEcLibres relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteEcLibres");
  }

  public org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre createScolMaquetteEcLibresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteEcLibre");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteEcLibres");
    return (org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre) eo;
  }

  public void deleteScolMaquetteEcLibresRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteEcLibres");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteEcLibresRelationships() {
    Enumeration objects = scolMaquetteEcLibres().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteEcLibresRelationship((org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre)objects.nextElement());
    }
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc> scolMaquetteEcs() {
    return (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc>)storedValueForKey("scolMaquetteEcs");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc> scolMaquetteEcs(EOQualifier qualifier) {
    return scolMaquetteEcs(qualifier, null, false);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc> scolMaquetteEcs(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteEcs(qualifier, null, fetch);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc> scolMaquetteEcs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolMaquetteEc.SCOL_FORMATION_ANNEE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.profiler.server.eof.EOScolMaquetteEc.fetchScolMaquetteEcs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteEcs();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteEc>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("adding " + object + " to scolMaquetteEcs relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteEcs");
  }

  public void removeFromScolMaquetteEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc object) {
    if (_EOScolFormationAnnee.LOG.isDebugEnabled()) {
      _EOScolFormationAnnee.LOG.debug("removing " + object + " from scolMaquetteEcs relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteEcs");
  }

  public org.cocktail.profiler.server.eof.EOScolMaquetteEc createScolMaquetteEcsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteEcs");
    return (org.cocktail.profiler.server.eof.EOScolMaquetteEc) eo;
  }

  public void deleteScolMaquetteEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteEcs");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteEcsRelationships() {
    Enumeration objects = scolMaquetteEcs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteEcsRelationship((org.cocktail.profiler.server.eof.EOScolMaquetteEc)objects.nextElement());
    }
  }


  public static EOScolFormationAnnee createScolFormationAnnee(EOEditingContext editingContext, String fannCourante
, Long fannDebut
, Long fannFin
, Long fannKey
) {
    EOScolFormationAnnee eo = (EOScolFormationAnnee) EOUtilities.createAndInsertInstance(editingContext, _EOScolFormationAnnee.ENTITY_NAME);    
		eo.setFannCourante(fannCourante);
		eo.setFannDebut(fannDebut);
		eo.setFannFin(fannFin);
		eo.setFannKey(fannKey);
    return eo;
  }

  public static NSArray<EOScolFormationAnnee> fetchAllScolFormationAnnees(EOEditingContext editingContext) {
    return _EOScolFormationAnnee.fetchAllScolFormationAnnees(editingContext, null);
  }

  public static NSArray<EOScolFormationAnnee> fetchAllScolFormationAnnees(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolFormationAnnee.fetchScolFormationAnnees(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolFormationAnnee> fetchScolFormationAnnees(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolFormationAnnee.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolFormationAnnee> eoObjects = (NSArray<EOScolFormationAnnee>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolFormationAnnee fetchScolFormationAnnee(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationAnnee.fetchScolFormationAnnee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationAnnee fetchScolFormationAnnee(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolFormationAnnee> eoObjects = _EOScolFormationAnnee.fetchScolFormationAnnees(editingContext, qualifier, null);
    EOScolFormationAnnee eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolFormationAnnee)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationAnnee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationAnnee fetchRequiredScolFormationAnnee(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolFormationAnnee.fetchRequiredScolFormationAnnee(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolFormationAnnee fetchRequiredScolFormationAnnee(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolFormationAnnee eoObject = _EOScolFormationAnnee.fetchScolFormationAnnee(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationAnnee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolFormationAnnee localInstanceIn(EOEditingContext editingContext, EOScolFormationAnnee eo) {
    EOScolFormationAnnee localInstance = (eo == null) ? null : (EOScolFormationAnnee)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
