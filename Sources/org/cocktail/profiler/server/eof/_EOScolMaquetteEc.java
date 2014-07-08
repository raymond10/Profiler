// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolMaquetteEc.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolMaquetteEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteEc";

	// Attributes
	public static final String FANN_KEY_KEY = "fannKey";
	public static final String FDSC_KEY_KEY = "fdscKey";
	public static final String MEC_BASE_KEY = "mecBase";
	public static final String MEC_CODE_KEY = "mecCode";
	public static final String MEC_HORAIRE_ETU_KEY = "mecHoraireEtu";
	public static final String MEC_KEY_KEY = "mecKey";
	public static final String MEC_LIBELLE_KEY = "mecLibelle";
	public static final String MEC_LIBELLE_COURT_KEY = "mecLibelleCourt";
	public static final String MEC_POINTS_KEY = "mecPoints";
	public static final String MEC_SESSION1_KEY = "mecSession1";
	public static final String MEC_SESSION2_KEY = "mecSession2";
	public static final String SCOL_MAQUETTE_REPARTITION_EC_ID_KEY = "scolMaquetteRepartitionEcID";

	// Relationships
	public static final String SCOL_EXAMEN_ENTETES_KEY = "scolExamenEntetes";
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_EC_LIBRES_KEY = "scolMaquetteEcLibres";
	public static final String SCOL_MAQUETTE_REPARTITION_ECS_KEY = "scolMaquetteRepartitionEcs";

  private static Logger LOG = Logger.getLogger(_EOScolMaquetteEc.class);

  public EOScolMaquetteEc localInstanceIn(EOEditingContext editingContext) {
    EOScolMaquetteEc localInstance = (EOScolMaquetteEc)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating fannKey from " + fannKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fannKey");
  }

  public String fdscKey() {
    return (String) storedValueForKey("fdscKey");
  }

  public void setFdscKey(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating fdscKey from " + fdscKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fdscKey");
  }

  public Long mecBase() {
    return (Long) storedValueForKey("mecBase");
  }

  public void setMecBase(Long value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecBase from " + mecBase() + " to " + value);
    }
    takeStoredValueForKey(value, "mecBase");
  }

  public String mecCode() {
    return (String) storedValueForKey("mecCode");
  }

  public void setMecCode(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecCode from " + mecCode() + " to " + value);
    }
    takeStoredValueForKey(value, "mecCode");
  }

  public java.math.BigDecimal mecHoraireEtu() {
    return (java.math.BigDecimal) storedValueForKey("mecHoraireEtu");
  }

  public void setMecHoraireEtu(java.math.BigDecimal value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecHoraireEtu from " + mecHoraireEtu() + " to " + value);
    }
    takeStoredValueForKey(value, "mecHoraireEtu");
  }

  public Long mecKey() {
    return (Long) storedValueForKey("mecKey");
  }

  public void setMecKey(Long value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecKey from " + mecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "mecKey");
  }

  public String mecLibelle() {
    return (String) storedValueForKey("mecLibelle");
  }

  public void setMecLibelle(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecLibelle from " + mecLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, "mecLibelle");
  }

  public String mecLibelleCourt() {
    return (String) storedValueForKey("mecLibelleCourt");
  }

  public void setMecLibelleCourt(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecLibelleCourt from " + mecLibelleCourt() + " to " + value);
    }
    takeStoredValueForKey(value, "mecLibelleCourt");
  }

  public java.math.BigDecimal mecPoints() {
    return (java.math.BigDecimal) storedValueForKey("mecPoints");
  }

  public void setMecPoints(java.math.BigDecimal value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecPoints from " + mecPoints() + " to " + value);
    }
    takeStoredValueForKey(value, "mecPoints");
  }

  public String mecSession1() {
    return (String) storedValueForKey("mecSession1");
  }

  public void setMecSession1(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecSession1 from " + mecSession1() + " to " + value);
    }
    takeStoredValueForKey(value, "mecSession1");
  }

  public String mecSession2() {
    return (String) storedValueForKey("mecSession2");
  }

  public void setMecSession2(String value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating mecSession2 from " + mecSession2() + " to " + value);
    }
    takeStoredValueForKey(value, "mecSession2");
  }

  public Long scolMaquetteRepartitionEcID() {
    return (Long) storedValueForKey("scolMaquetteRepartitionEcID");
  }

  public void setScolMaquetteRepartitionEcID(Long value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEc.LOG.debug( "updating scolMaquetteRepartitionEcID from " + scolMaquetteRepartitionEcID() + " to " + value);
    }
    takeStoredValueForKey(value, "scolMaquetteRepartitionEcID");
  }

  public org.cocktail.profiler.server.eof.EOScolFormationAnnee scolFormationAnnee() {
    return (org.cocktail.profiler.server.eof.EOScolFormationAnnee)storedValueForKey("scolFormationAnnee");
  }

  public void setScolFormationAnneeRelationship(org.cocktail.profiler.server.eof.EOScolFormationAnnee value) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("updating scolFormationAnnee from " + scolFormationAnnee() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolFormationAnnee oldValue = scolFormationAnnee();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationAnnee");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationAnnee");
    }
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolExamenEntete.SCOL_MAQUETTE_EC_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("adding " + object + " to scolExamenEntetes relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolExamenEntetes");
  }

  public void removeFromScolExamenEntetesRelationship(org.cocktail.profiler.server.eof.EOScolExamenEntete object) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("removing " + object + " from scolExamenEntetes relationship");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre.SCOL_MAQUETTE_EC_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("adding " + object + " to scolMaquetteEcLibres relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteEcLibres");
  }

  public void removeFromScolMaquetteEcLibresRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEcLibre object) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("removing " + object + " from scolMaquetteEcLibres relationship");
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

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc> scolMaquetteRepartitionEcs() {
    return (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc>)storedValueForKey("scolMaquetteRepartitionEcs");
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc> scolMaquetteRepartitionEcs(EOQualifier qualifier) {
    return scolMaquetteRepartitionEcs(qualifier, null);
  }

  public NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc> scolMaquetteRepartitionEcs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc> results;
      results = scolMaquetteRepartitionEcs();
      if (qualifier != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToScolMaquetteRepartitionEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc object) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("adding " + object + " to scolMaquetteRepartitionEcs relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public void removeFromScolMaquetteRepartitionEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc object) {
    if (_EOScolMaquetteEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteEc.LOG.debug("removing " + object + " from scolMaquetteRepartitionEcs relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc createScolMaquetteRepartitionEcsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionEcs");
    return (org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc) eo;
  }

  public void deleteScolMaquetteRepartitionEcsRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionEcsRelationships() {
    Enumeration objects = scolMaquetteRepartitionEcs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionEcsRelationship((org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc)objects.nextElement());
    }
  }


  public static EOScolMaquetteEc createScolMaquetteEc(EOEditingContext editingContext, Long fannKey
, String fdscKey
, Long mecBase
, String mecCode
, java.math.BigDecimal mecHoraireEtu
, Long mecKey
, java.math.BigDecimal mecPoints
, Long scolMaquetteRepartitionEcID
) {
    EOScolMaquetteEc eo = (EOScolMaquetteEc) EOUtilities.createAndInsertInstance(editingContext, _EOScolMaquetteEc.ENTITY_NAME);    
		eo.setFannKey(fannKey);
		eo.setFdscKey(fdscKey);
		eo.setMecBase(mecBase);
		eo.setMecCode(mecCode);
		eo.setMecHoraireEtu(mecHoraireEtu);
		eo.setMecKey(mecKey);
		eo.setMecPoints(mecPoints);
		eo.setScolMaquetteRepartitionEcID(scolMaquetteRepartitionEcID);
    return eo;
  }

  public static NSArray<EOScolMaquetteEc> fetchAllScolMaquetteEcs(EOEditingContext editingContext) {
    return _EOScolMaquetteEc.fetchAllScolMaquetteEcs(editingContext, null);
  }

  public static NSArray<EOScolMaquetteEc> fetchAllScolMaquetteEcs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolMaquetteEc.fetchScolMaquetteEcs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolMaquetteEc> fetchScolMaquetteEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolMaquetteEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolMaquetteEc> eoObjects = (NSArray<EOScolMaquetteEc>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolMaquetteEc fetchScolMaquetteEc(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteEc.fetchScolMaquetteEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteEc fetchScolMaquetteEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolMaquetteEc> eoObjects = _EOScolMaquetteEc.fetchScolMaquetteEcs(editingContext, qualifier, null);
    EOScolMaquetteEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolMaquetteEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteEc fetchRequiredScolMaquetteEc(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteEc.fetchRequiredScolMaquetteEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteEc fetchRequiredScolMaquetteEc(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolMaquetteEc eoObject = _EOScolMaquetteEc.fetchScolMaquetteEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteEc localInstanceIn(EOEditingContext editingContext, EOScolMaquetteEc eo) {
    EOScolMaquetteEc localInstance = (eo == null) ? null : (EOScolMaquetteEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
