// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOInscDipl.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOInscDipl extends  EOGenericRecord {
	public static final String ENTITY_NAME = "InscDipl";

	// Attributes
	public static final String GRPD_NUMERO_KEY = "grpdNumero";
	public static final String IDIPL_AMENAGEMENT_KEY = "idiplAmenagement";
	public static final String IDIPL_ANNEE_SUIVIE_KEY = "idiplAnneeSuivie";
	public static final String IDIPL_DATE_DEMISSION_KEY = "idiplDateDemission";
	public static final String IDIPL_DATE_INSC_KEY = "idiplDateInsc";
	public static final String IDIPL_DIPLOMABLE_KEY = "idiplDiplomable";
	public static final String IDIPL_MOY_ETU_KEY = "idiplMoyEtu";
	public static final String IDIPL_NOTE_PONDERATION_KEY = "idiplNotePonderation";
	public static final String IDIPL_NUMERO_DIPL_KEY = "idiplNumeroDipl";
	public static final String IDIPL_PASSAGE_CONDITIONNEL_KEY = "idiplPassageConditionnel";
	public static final String IDIPL_RANG_KEY = "idiplRang";
	public static final String IDIPL_SEMESTRE_KEY = "idiplSemestre";
	public static final String MENT_CODE_KEY = "mentCode";
	public static final String MSTA_CODE_KEY = "mstaCode";

	// Relationships
	public static final String TO_HISTORIQUE_KEY = "toHistorique";
	public static final String TO_SCOL_FORMATION_SPECIALISATION_KEY = "toScolFormationSpecialisation";

  private static Logger LOG = Logger.getLogger(_EOInscDipl.class);

  public EOInscDipl localInstanceIn(EOEditingContext editingContext) {
    EOInscDipl localInstance = (EOInscDipl)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer grpdNumero() {
    return (Integer) storedValueForKey("grpdNumero");
  }

  public void setGrpdNumero(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating grpdNumero from " + grpdNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "grpdNumero");
  }

  public Integer idiplAmenagement() {
    return (Integer) storedValueForKey("idiplAmenagement");
  }

  public void setIdiplAmenagement(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplAmenagement from " + idiplAmenagement() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplAmenagement");
  }

  public Integer idiplAnneeSuivie() {
    return (Integer) storedValueForKey("idiplAnneeSuivie");
  }

  public void setIdiplAnneeSuivie(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplAnneeSuivie from " + idiplAnneeSuivie() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplAnneeSuivie");
  }

  public NSTimestamp idiplDateDemission() {
    return (NSTimestamp) storedValueForKey("idiplDateDemission");
  }

  public void setIdiplDateDemission(NSTimestamp value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplDateDemission from " + idiplDateDemission() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplDateDemission");
  }

  public NSTimestamp idiplDateInsc() {
    return (NSTimestamp) storedValueForKey("idiplDateInsc");
  }

  public void setIdiplDateInsc(NSTimestamp value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplDateInsc from " + idiplDateInsc() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplDateInsc");
  }

  public Integer idiplDiplomable() {
    return (Integer) storedValueForKey("idiplDiplomable");
  }

  public void setIdiplDiplomable(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplDiplomable from " + idiplDiplomable() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplDiplomable");
  }

  public java.math.BigDecimal idiplMoyEtu() {
    return (java.math.BigDecimal) storedValueForKey("idiplMoyEtu");
  }

  public void setIdiplMoyEtu(java.math.BigDecimal value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplMoyEtu from " + idiplMoyEtu() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplMoyEtu");
  }

  public java.math.BigDecimal idiplNotePonderation() {
    return (java.math.BigDecimal) storedValueForKey("idiplNotePonderation");
  }

  public void setIdiplNotePonderation(java.math.BigDecimal value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplNotePonderation from " + idiplNotePonderation() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplNotePonderation");
  }

  public Integer idiplNumeroDipl() {
    return (Integer) storedValueForKey("idiplNumeroDipl");
  }

  public void setIdiplNumeroDipl(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplNumeroDipl from " + idiplNumeroDipl() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplNumeroDipl");
  }

  public String idiplPassageConditionnel() {
    return (String) storedValueForKey("idiplPassageConditionnel");
  }

  public void setIdiplPassageConditionnel(String value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplPassageConditionnel from " + idiplPassageConditionnel() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplPassageConditionnel");
  }

  public Integer idiplRang() {
    return (Integer) storedValueForKey("idiplRang");
  }

  public void setIdiplRang(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplRang from " + idiplRang() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplRang");
  }

  public Integer idiplSemestre() {
    return (Integer) storedValueForKey("idiplSemestre");
  }

  public void setIdiplSemestre(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating idiplSemestre from " + idiplSemestre() + " to " + value);
    }
    takeStoredValueForKey(value, "idiplSemestre");
  }

  public String mentCode() {
    return (String) storedValueForKey("mentCode");
  }

  public void setMentCode(String value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating mentCode from " + mentCode() + " to " + value);
    }
    takeStoredValueForKey(value, "mentCode");
  }

  public Integer mstaCode() {
    return (Integer) storedValueForKey("mstaCode");
  }

  public void setMstaCode(Integer value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
    	_EOInscDipl.LOG.debug( "updating mstaCode from " + mstaCode() + " to " + value);
    }
    takeStoredValueForKey(value, "mstaCode");
  }

  public org.cocktail.profiler.server.eof.EOHistorique toHistorique() {
    return (org.cocktail.profiler.server.eof.EOHistorique)storedValueForKey("toHistorique");
  }

  public void setToHistoriqueRelationship(org.cocktail.profiler.server.eof.EOHistorique value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
      _EOInscDipl.LOG.debug("updating toHistorique from " + toHistorique() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOHistorique oldValue = toHistorique();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toHistorique");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toHistorique");
    }
  }
  
  public org.cocktail.profiler.server.eof.EOScolFormationSpecialisation toScolFormationSpecialisation() {
    return (org.cocktail.profiler.server.eof.EOScolFormationSpecialisation)storedValueForKey("toScolFormationSpecialisation");
  }

  public void setToScolFormationSpecialisationRelationship(org.cocktail.profiler.server.eof.EOScolFormationSpecialisation value) {
    if (_EOInscDipl.LOG.isDebugEnabled()) {
      _EOInscDipl.LOG.debug("updating toScolFormationSpecialisation from " + toScolFormationSpecialisation() + " to " + value);
    }
    if (value == null) {
    	org.cocktail.profiler.server.eof.EOScolFormationSpecialisation oldValue = toScolFormationSpecialisation();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toScolFormationSpecialisation");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toScolFormationSpecialisation");
    }
  }
  

  public static EOInscDipl createInscDipl(EOEditingContext editingContext, Integer idiplAmenagement
, Integer idiplAnneeSuivie
, NSTimestamp idiplDateInsc
, Integer idiplDiplomable
, String idiplPassageConditionnel
, org.cocktail.profiler.server.eof.EOHistorique toHistorique, org.cocktail.profiler.server.eof.EOScolFormationSpecialisation toScolFormationSpecialisation) {
    EOInscDipl eo = (EOInscDipl) EOUtilities.createAndInsertInstance(editingContext, _EOInscDipl.ENTITY_NAME);    
		eo.setIdiplAmenagement(idiplAmenagement);
		eo.setIdiplAnneeSuivie(idiplAnneeSuivie);
		eo.setIdiplDateInsc(idiplDateInsc);
		eo.setIdiplDiplomable(idiplDiplomable);
		eo.setIdiplPassageConditionnel(idiplPassageConditionnel);
    eo.setToHistoriqueRelationship(toHistorique);
    eo.setToScolFormationSpecialisationRelationship(toScolFormationSpecialisation);
    return eo;
  }

  public static NSArray<EOInscDipl> fetchAllInscDipls(EOEditingContext editingContext) {
    return _EOInscDipl.fetchAllInscDipls(editingContext, null);
  }

  public static NSArray<EOInscDipl> fetchAllInscDipls(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOInscDipl.fetchInscDipls(editingContext, null, sortOrderings);
  }

  public static NSArray<EOInscDipl> fetchInscDipls(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOInscDipl.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOInscDipl> eoObjects = (NSArray<EOInscDipl>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOInscDipl fetchInscDipl(EOEditingContext editingContext, String keyName, Object value) {
    return _EOInscDipl.fetchInscDipl(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOInscDipl fetchInscDipl(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOInscDipl> eoObjects = _EOInscDipl.fetchInscDipls(editingContext, qualifier, null);
    EOInscDipl eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOInscDipl)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one InscDipl that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOInscDipl fetchRequiredInscDipl(EOEditingContext editingContext, String keyName, Object value) {
    return _EOInscDipl.fetchRequiredInscDipl(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOInscDipl fetchRequiredInscDipl(EOEditingContext editingContext, EOQualifier qualifier) {
    EOInscDipl eoObject = _EOInscDipl.fetchInscDipl(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no InscDipl that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOInscDipl localInstanceIn(EOEditingContext editingContext, EOInscDipl eo) {
    EOInscDipl localInstance = (eo == null) ? null : (EOInscDipl)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
