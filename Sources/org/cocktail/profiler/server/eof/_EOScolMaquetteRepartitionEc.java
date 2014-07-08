// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOScolMaquetteRepartitionEc.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOScolMaquetteRepartitionEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteRepartitionEc";

	// Attributes
	public static final String FANN_KEY_KEY = "fannKey";
	public static final String MEC_KEY_KEY = "mecKey";
	public static final String MREC_BONIFIABLE_KEY = "mrecBonifiable";
	public static final String MREC_COEFFICIENT_KEY = "mrecCoefficient";
	public static final String MREC_COMPTABILISABLE_KEY = "mrecComptabilisable";
	public static final String MREC_KEY_KEY = "mrecKey";
	public static final String MREC_NIVEAU_KEY = "mrecNiveau";
	public static final String MREC_NOTE_BASE_KEY = "mrecNoteBase";
	public static final String MREC_NOTE_ELIMINATION_KEY = "mrecNoteElimination";
	public static final String MREC_NOTE_OBTENTION_KEY = "mrecNoteObtention";
	public static final String MREC_ORDRE_KEY = "mrecOrdre";
	public static final String MTEC_CODE_KEY = "mtecCode";
	public static final String MUE_KEY_KEY = "mueKey";

	// Relationships
	public static final String TO_SCOL_MAQUETTE_EC_KEY = "toScolMaquetteEc";

  private static Logger LOG = Logger.getLogger(_EOScolMaquetteRepartitionEc.class);

  public EOScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext) {
    EOScolMaquetteRepartitionEc localInstance = (EOScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating fannKey from " + fannKey() + " to " + value);
    }
    takeStoredValueForKey(value, "fannKey");
  }

  public Long mecKey() {
    return (Long) storedValueForKey("mecKey");
  }

  public void setMecKey(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mecKey from " + mecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "mecKey");
  }

  public Long mrecBonifiable() {
    return (Long) storedValueForKey("mrecBonifiable");
  }

  public void setMrecBonifiable(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecBonifiable from " + mrecBonifiable() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecBonifiable");
  }

  public java.math.BigDecimal mrecCoefficient() {
    return (java.math.BigDecimal) storedValueForKey("mrecCoefficient");
  }

  public void setMrecCoefficient(java.math.BigDecimal value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecCoefficient from " + mrecCoefficient() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecCoefficient");
  }

  public Long mrecComptabilisable() {
    return (Long) storedValueForKey("mrecComptabilisable");
  }

  public void setMrecComptabilisable(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecComptabilisable from " + mrecComptabilisable() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecComptabilisable");
  }

  public Long mrecKey() {
    return (Long) storedValueForKey("mrecKey");
  }

  public void setMrecKey(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecKey from " + mrecKey() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecKey");
  }

  public String mrecNiveau() {
    return (String) storedValueForKey("mrecNiveau");
  }

  public void setMrecNiveau(String value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecNiveau from " + mrecNiveau() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecNiveau");
  }

  public java.math.BigDecimal mrecNoteBase() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteBase");
  }

  public void setMrecNoteBase(java.math.BigDecimal value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecNoteBase from " + mrecNoteBase() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecNoteBase");
  }

  public java.math.BigDecimal mrecNoteElimination() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteElimination");
  }

  public void setMrecNoteElimination(java.math.BigDecimal value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecNoteElimination from " + mrecNoteElimination() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecNoteElimination");
  }

  public java.math.BigDecimal mrecNoteObtention() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteObtention");
  }

  public void setMrecNoteObtention(java.math.BigDecimal value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecNoteObtention from " + mrecNoteObtention() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecNoteObtention");
  }

  public Long mrecOrdre() {
    return (Long) storedValueForKey("mrecOrdre");
  }

  public void setMrecOrdre(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mrecOrdre from " + mrecOrdre() + " to " + value);
    }
    takeStoredValueForKey(value, "mrecOrdre");
  }

  public String mtecCode() {
    return (String) storedValueForKey("mtecCode");
  }

  public void setMtecCode(String value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mtecCode from " + mtecCode() + " to " + value);
    }
    takeStoredValueForKey(value, "mtecCode");
  }

  public Long mueKey() {
    return (Long) storedValueForKey("mueKey");
  }

  public void setMueKey(Long value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
    	_EOScolMaquetteRepartitionEc.LOG.debug( "updating mueKey from " + mueKey() + " to " + value);
    }
    takeStoredValueForKey(value, "mueKey");
  }

  public org.cocktail.profiler.server.eof.EOScolMaquetteEc toScolMaquetteEc() {
    return (org.cocktail.profiler.server.eof.EOScolMaquetteEc)storedValueForKey("toScolMaquetteEc");
  }

  public void setToScolMaquetteEcRelationship(org.cocktail.profiler.server.eof.EOScolMaquetteEc value) {
    if (_EOScolMaquetteRepartitionEc.LOG.isDebugEnabled()) {
      _EOScolMaquetteRepartitionEc.LOG.debug("updating toScolMaquetteEc from " + toScolMaquetteEc() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolMaquetteEc oldValue = toScolMaquetteEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toScolMaquetteEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toScolMaquetteEc");
    }
  }
  

  public static EOScolMaquetteRepartitionEc createScolMaquetteRepartitionEc(EOEditingContext editingContext, Long fannKey
, Long mecKey
, Long mrecBonifiable
, java.math.BigDecimal mrecCoefficient
, Long mrecComptabilisable
, Long mrecKey
, java.math.BigDecimal mrecNoteBase
, java.math.BigDecimal mrecNoteObtention
, Long mrecOrdre
, String mtecCode
, Long mueKey
) {
    EOScolMaquetteRepartitionEc eo = (EOScolMaquetteRepartitionEc) EOUtilities.createAndInsertInstance(editingContext, _EOScolMaquetteRepartitionEc.ENTITY_NAME);    
		eo.setFannKey(fannKey);
		eo.setMecKey(mecKey);
		eo.setMrecBonifiable(mrecBonifiable);
		eo.setMrecCoefficient(mrecCoefficient);
		eo.setMrecComptabilisable(mrecComptabilisable);
		eo.setMrecKey(mrecKey);
		eo.setMrecNoteBase(mrecNoteBase);
		eo.setMrecNoteObtention(mrecNoteObtention);
		eo.setMrecOrdre(mrecOrdre);
		eo.setMtecCode(mtecCode);
		eo.setMueKey(mueKey);
    return eo;
  }

  public static NSArray<EOScolMaquetteRepartitionEc> fetchAllScolMaquetteRepartitionEcs(EOEditingContext editingContext) {
    return _EOScolMaquetteRepartitionEc.fetchAllScolMaquetteRepartitionEcs(editingContext, null);
  }

  public static NSArray<EOScolMaquetteRepartitionEc> fetchAllScolMaquetteRepartitionEcs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext, null, sortOrderings);
  }

  public static NSArray<EOScolMaquetteRepartitionEc> fetchScolMaquetteRepartitionEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOScolMaquetteRepartitionEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOScolMaquetteRepartitionEc> eoObjects = (NSArray<EOScolMaquetteRepartitionEc>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOScolMaquetteRepartitionEc fetchScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteRepartitionEc fetchScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOScolMaquetteRepartitionEc> eoObjects = _EOScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext, qualifier, null);
    EOScolMaquetteRepartitionEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOScolMaquetteRepartitionEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteRepartitionEc fetchRequiredScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _EOScolMaquetteRepartitionEc.fetchRequiredScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOScolMaquetteRepartitionEc fetchRequiredScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    EOScolMaquetteRepartitionEc eoObject = _EOScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext, EOScolMaquetteRepartitionEc eo) {
    EOScolMaquetteRepartitionEc localInstance = (eo == null) ? null : (EOScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
