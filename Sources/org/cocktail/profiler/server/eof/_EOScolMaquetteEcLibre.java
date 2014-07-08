// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolMaquetteEcLibre.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolMaquetteEcLibre extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteEcLibre";

	// Attributes
	public static final String FANN_KEY_KEY = "fannKey";
	public static final String MEC_KEY_KEY = "mecKey";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";

  private static Logger LOG = Logger.getLogger(_EOScolMaquetteEcLibre.class);

  public EOScolMaquetteEcLibre localInstanceIn(EOEditingContext editingContext) {
    EOScolMaquetteEcLibre localInstance = (EOScolMaquetteEcLibre)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    if (_EOScolMaquetteEcLibre.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEcLibre.LOG.debug( "updating fannKey from " + fannKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fannKey");
  }

  public Long mecKey() {
    return (Long) storedValueForKey("mecKey");
  }

  public void setMecKey(Long value) {
    if (_EOScolMaquetteEcLibre.LOG.isDebugEnabled()) {
    	_EOScolMaquetteEcLibre.LOG.debug( "updating mecKey from " + mecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "mecKey");
  }

  public org.cocktail.profiler.server.eof.EOScolFormationAnnee scolFormationAnnee() {
    return (org.cocktail.profiler.server.eof.EOScolFormationAnnee)storedValueForKey("scolFormationAnnee");
  }

  public void setScolFormationAnneeRelationship(org.cocktail.profiler.server.eof.EOScolFormationAnnee value) {
    if (_EOScolMaquetteEcLibre.LOG.isDebugEnabled()) {
      _EOScolMaquetteEcLibre.LOG.debug("updating scolFormationAnnee from " + scolFormationAnnee() + " to " + value);
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
  
  public org.cocktail.profiler.server.eof.EOScolMaquetteEc scolMaquetteEc() {
    return (org.cocktail.profiler.server.eof.EOScolMaquetteEc)storedValueForKey("scolMaquetteEc");
  }

  public void setScolMaquetteEcRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc value) {
    if (_EOScolMaquetteEcLibre.LOG.isDebugEnabled()) {
      _EOScolMaquetteEcLibre.LOG.debug("updating scolMaquetteEc from " + scolMaquetteEc() + " to " + value);
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
  

  public static EOScolMaquetteEcLibre createScolMaquetteEcLibre(EOEditingContext editingContext, Long fannKey
, Long mecKey
) {
    EOScolMaquetteEcLibre eo = (EOScolMaquetteEcLibre) EOUtilities.createAndInsertInstance(editingContext, _EOScolMaquetteEcLibre.ENTITY_NAME);    
		eo.setFannKey(fannKey);
		eo.setMecKey(mecKey);
    return eo;
  }

  public static NSArray<EOScolMaquetteEcLibre> fetchAllScolMaquetteEcLibres(EOEditingContext editingContext) {
    return _EOScolMaquetteEcLibre.fetchAllScolMaquetteEcLibres(editingContext, null);
  }

  public static NSArray<EOScolMaquetteEcLibre> fetchAllScolMaquetteEcLibres(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolMaquetteEcLibre.fetchScolMaquetteEcLibres(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolMaquetteEcLibre> fetchScolMaquetteEcLibres(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolMaquetteEcLibre.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolMaquetteEcLibre> eoObjects = (NSArray<EOScolMaquetteEcLibre>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolMaquetteEcLibre fetchScolMaquetteEcLibre(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteEcLibre.fetchScolMaquetteEcLibre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteEcLibre fetchScolMaquetteEcLibre(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolMaquetteEcLibre> eoObjects = _EOScolMaquetteEcLibre.fetchScolMaquetteEcLibres(editingContext, qualifier, null);
    EOScolMaquetteEcLibre eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolMaquetteEcLibre)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteEcLibre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteEcLibre fetchRequiredScolMaquetteEcLibre(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteEcLibre.fetchRequiredScolMaquetteEcLibre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteEcLibre fetchRequiredScolMaquetteEcLibre(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolMaquetteEcLibre eoObject = _EOScolMaquetteEcLibre.fetchScolMaquetteEcLibre(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteEcLibre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteEcLibre localInstanceIn(EOEditingContext editingContext, EOScolMaquetteEcLibre eo) {
    EOScolMaquetteEcLibre localInstance = (eo == null) ? null : (EOScolMaquetteEcLibre)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
