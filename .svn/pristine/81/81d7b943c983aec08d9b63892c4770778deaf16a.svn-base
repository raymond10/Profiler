// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to ScolMaquetteEcScolMaquetteRepartitionEc.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _ScolMaquetteEcScolMaquetteRepartitionEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteEcScolMaquetteRepartitionEc";

	// Attributes
	public static final String SCOL_MAQUETTE_EC_MEC_KEY_KEY = "scolMaquetteEcMecKey";
	public static final String SCOL_MAQUETTE_REPARTITION_EC_MREC_KEY_KEY = "scolMaquetteRepartitionEcMrecKey";

	// Relationships
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";
	public static final String SCOL_MAQUETTE_REPARTITION_EC_KEY = "scolMaquetteRepartitionEc";

  private static Logger LOG = Logger.getLogger(_ScolMaquetteEcScolMaquetteRepartitionEc.class);

  public ScolMaquetteEcScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext) {
    ScolMaquetteEcScolMaquetteRepartitionEc localInstance = (ScolMaquetteEcScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long scolMaquetteEcMecKey() {
    return (Long) storedValueForKey("scolMaquetteEcMecKey");
  }

  public void setScolMaquetteEcMecKey(Long value) {
    if (_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.debug( "updating scolMaquetteEcMecKey from " + scolMaquetteEcMecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "scolMaquetteEcMecKey");
  }

  public Long scolMaquetteRepartitionEcMrecKey() {
    return (Long) storedValueForKey("scolMaquetteRepartitionEcMrecKey");
  }

  public void setScolMaquetteRepartitionEcMrecKey(Long value) {
    if (_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.debug( "updating scolMaquetteRepartitionEcMrecKey from " + scolMaquetteRepartitionEcMrecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "scolMaquetteRepartitionEcMrecKey");
  }

  public org.cocktail.profiler.server.eof.EOScolMaquetteEc scolMaquetteEc() {
    return (org.cocktail.profiler.server.eof.EOScolMaquetteEc)storedValueForKey("scolMaquetteEc");
  }

  public void setScolMaquetteEcRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc value) {
    if (_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
      _ScolMaquetteEcScolMaquetteRepartitionEc.LOG.debug("updating scolMaquetteEc from " + scolMaquetteEc() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolMaquetteEc oldValue = scolMaquetteEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteEc");
    }
  }
  
  public org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc scolMaquetteRepartitionEc() {
    return (org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc)storedValueForKey("scolMaquetteRepartitionEc");
  }

  public void setScolMaquetteRepartitionEcRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc value) {
    if (_ScolMaquetteEcScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
      _ScolMaquetteEcScolMaquetteRepartitionEc.LOG.debug("updating scolMaquetteRepartitionEc from " + scolMaquetteRepartitionEc() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc oldValue = scolMaquetteRepartitionEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteRepartitionEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteRepartitionEc");
    }
  }
  

  public static ScolMaquetteEcScolMaquetteRepartitionEc createScolMaquetteEcScolMaquetteRepartitionEc(EOEditingContext editingContext, Long scolMaquetteEcMecKey
, Long scolMaquetteRepartitionEcMrecKey
, org.cocktail.profiler.server.eof.EOScolMaquetteEc scolMaquetteEc, org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc scolMaquetteRepartitionEc) {
    ScolMaquetteEcScolMaquetteRepartitionEc eo = (ScolMaquetteEcScolMaquetteRepartitionEc) EOUtilities.createAndInsertInstance(editingContext, _ScolMaquetteEcScolMaquetteRepartitionEc.ENTITY_NAME);    
		eo.setScolMaquetteEcMecKey(scolMaquetteEcMecKey);
		eo.setScolMaquetteRepartitionEcMrecKey(scolMaquetteRepartitionEcMrecKey);
    eo.setScolMaquetteEcRelationship(scolMaquetteEc);
    eo.setScolMaquetteRepartitionEcRelationship(scolMaquetteRepartitionEc);
    return eo;
  }

  public static NSArray<ScolMaquetteEcScolMaquetteRepartitionEc> fetchAllScolMaquetteEcScolMaquetteRepartitionEcs(EOEditingContext editingContext) {
    return _ScolMaquetteEcScolMaquetteRepartitionEc.fetchAllScolMaquetteEcScolMaquetteRepartitionEcs(editingContext, null);
  }

  public static NSArray<ScolMaquetteEcScolMaquetteRepartitionEc> fetchAllScolMaquetteEcScolMaquetteRepartitionEcs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ScolMaquetteEcScolMaquetteRepartitionEc.fetchScolMaquetteEcScolMaquetteRepartitionEcs(editingContext, null, sortOrderings);
  }

  public static NSArray<ScolMaquetteEcScolMaquetteRepartitionEc> fetchScolMaquetteEcScolMaquetteRepartitionEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteEcScolMaquetteRepartitionEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ScolMaquetteEcScolMaquetteRepartitionEc> eoObjects = (NSArray<ScolMaquetteEcScolMaquetteRepartitionEc>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteEcScolMaquetteRepartitionEc fetchScolMaquetteEcScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEcScolMaquetteRepartitionEc.fetchScolMaquetteEcScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEcScolMaquetteRepartitionEc fetchScolMaquetteEcScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ScolMaquetteEcScolMaquetteRepartitionEc> eoObjects = _ScolMaquetteEcScolMaquetteRepartitionEc.fetchScolMaquetteEcScolMaquetteRepartitionEcs(editingContext, qualifier, null);
    ScolMaquetteEcScolMaquetteRepartitionEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteEcScolMaquetteRepartitionEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteEcScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEcScolMaquetteRepartitionEc fetchRequiredScolMaquetteEcScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEcScolMaquetteRepartitionEc.fetchRequiredScolMaquetteEcScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEcScolMaquetteRepartitionEc fetchRequiredScolMaquetteEcScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteEcScolMaquetteRepartitionEc eoObject = _ScolMaquetteEcScolMaquetteRepartitionEc.fetchScolMaquetteEcScolMaquetteRepartitionEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteEcScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEcScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext, ScolMaquetteEcScolMaquetteRepartitionEc eo) {
    ScolMaquetteEcScolMaquetteRepartitionEc localInstance = (eo == null) ? null : (ScolMaquetteEcScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
