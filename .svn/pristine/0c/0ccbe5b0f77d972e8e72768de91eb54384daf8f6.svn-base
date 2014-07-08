// $LastChangedRevision: 5810 $ DO NOT EDIT.  Make changes to EOHistorique.java instead.
package org.cocktail.profiler.server.eof;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOHistorique extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Historique";

	// Attributes
	public static final String COTI_CODE_KEY = "cotiCode";
	public static final String DACT_CODE_KEY = "dactCode";
	public static final String DSPE_CODE_FUTUR_KEY = "dspeCodeFutur";
	public static final String ETUD_NUMERO_KEY = "etudNumero";
	public static final String HIST1_INSC_DEUG_DUT_KEY = "hist1InscDeugDut";
	public static final String HIST_ACAD_BOURSE_KEY = "histAcadBourse";
	public static final String HIST_ACCES_INFO_KEY = "histAccesInfo";
	public static final String HIST_ACTIV_PROF_KEY = "histActivProf";
	public static final String HIST_ADH_AGME_KEY = "histAdhAgme";
	public static final String HIST_AFFSS_KEY = "histAffss";
	public static final String HIST_ANNEE_DER_DIPL_KEY = "histAnneeDerDipl";
	public static final String HIST_ANNEE_DER_ETAB_KEY = "histAnneeDerEtab";
	public static final String HIST_ANNEE_DIPL_FUTUR_KEY = "histAnneeDiplFutur";
	public static final String HIST_ANNEE_SCOL_KEY = "histAnneeScol";
	public static final String HIST_ASSURANCE_CIVILE_KEY = "histAssuranceCivile";
	public static final String HIST_ASSURANCE_CIVILE_CIE_KEY = "histAssuranceCivileCie";
	public static final String HIST_ASSURANCE_CIVILE_NUM_KEY = "histAssuranceCivileNum";
	public static final String HIST_AUTRE_CAS_EXO_KEY = "histAutreCasExo";
	public static final String HIST_AYANT_DROIT_KEY = "histAyantDroit";
	public static final String HIST_BOURSE_KEY = "histBourse";
	public static final String HIST_DATE_TRANSFERT_KEY = "histDateTransfert";
	public static final String HIST_DEM_EMPL_KEY = "histDemEmpl";
	public static final String HIST_DUREE_INT_KEY = "histDureeInt";
	public static final String HIST_ECH_BOURSE_KEY = "histEchBourse";
	public static final String HIST_ENS_DER_ETAB_KEY = "histEnsDerEtab";
	public static final String HIST_FOR_PROF_KEY = "histForProf";
	public static final String HIST_INT_ETUD_KEY = "histIntEtud";
	public static final String HIST_LIBELLE_AUT_ETAB_KEY = "histLibelleAutEtab";
	public static final String HIST_LIBELLE_DER_DIPL_KEY = "histLibelleDerDipl";
	public static final String HIST_LIBELLE_DER_ETAB_KEY = "histLibelleDerEtab";
	public static final String HIST_LIBELLE_PROF_KEY = "histLibelleProf";
	public static final String HIST_NB_INSC_DEUG_KEY = "histNbInscDeug";
	public static final String HIST_NUMERO_KEY = "histNumero";
	public static final String HIST_NUMERO_ALLOC_KEY = "histNumeroAlloc";
	public static final String HIST_REDOUBLE_KEY = "histRedouble";
	public static final String HIST_REMARQUES_KEY = "histRemarques";
	public static final String HIST_RESTE_BU_KEY = "histResteBu";
	public static final String HIST_SALARIE_KEY = "histSalarie";
	public static final String HIST_SALARIE_LIBELLE_KEY = "histSalarieLibelle";
	public static final String HIST_TELEENS_KEY = "histTeleens";
	public static final String HIST_TRANSFERT_KEY = "histTransfert";
	public static final String HIST_TYPE_FORMATION_KEY = "histTypeFormation";
	public static final String HIST_TYPE_REGIME_KEY = "histTypeRegime";
	public static final String HIST_VILLE_AUT_ETAB_KEY = "histVilleAutEtab";
	public static final String HIST_VILLE_DER_DIPL_KEY = "histVilleDerDipl";
	public static final String HIST_VILLE_DER_ETAB_KEY = "histVilleDerEtab";
	public static final String PRO_CODE_ETUD_KEY = "proCodeEtud";

	// Relationships
	public static final String TO_INSC_DIPLS_KEY = "toInscDipls";

  private static Logger LOG = Logger.getLogger(_EOHistorique.class);

  public EOHistorique localInstanceIn(EOEditingContext editingContext) {
    EOHistorique localInstance = (EOHistorique)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String cotiCode() {
    return (String) storedValueForKey("cotiCode");
  }

  public void setCotiCode(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating cotiCode from " + cotiCode() + " to " + value);
    }
    takeStoredValueForKey(value, "cotiCode");
  }

  public String dactCode() {
    return (String) storedValueForKey("dactCode");
  }

  public void setDactCode(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating dactCode from " + dactCode() + " to " + value);
    }
    takeStoredValueForKey(value, "dactCode");
  }

  public Integer dspeCodeFutur() {
    return (Integer) storedValueForKey("dspeCodeFutur");
  }

  public void setDspeCodeFutur(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating dspeCodeFutur from " + dspeCodeFutur() + " to " + value);
    }
    takeStoredValueForKey(value, "dspeCodeFutur");
  }

  public Integer etudNumero() {
    return (Integer) storedValueForKey("etudNumero");
  }

  public void setEtudNumero(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating etudNumero from " + etudNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "etudNumero");
  }

  public Integer hist1InscDeugDut() {
    return (Integer) storedValueForKey("hist1InscDeugDut");
  }

  public void setHist1InscDeugDut(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating hist1InscDeugDut from " + hist1InscDeugDut() + " to " + value);
    }
    takeStoredValueForKey(value, "hist1InscDeugDut");
  }

  public String histAcadBourse() {
    return (String) storedValueForKey("histAcadBourse");
  }

  public void setHistAcadBourse(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAcadBourse from " + histAcadBourse() + " to " + value);
    }
    takeStoredValueForKey(value, "histAcadBourse");
  }

  public Integer histAccesInfo() {
    return (Integer) storedValueForKey("histAccesInfo");
  }

  public void setHistAccesInfo(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAccesInfo from " + histAccesInfo() + " to " + value);
    }
    takeStoredValueForKey(value, "histAccesInfo");
  }

  public Integer histActivProf() {
    return (Integer) storedValueForKey("histActivProf");
  }

  public void setHistActivProf(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histActivProf from " + histActivProf() + " to " + value);
    }
    takeStoredValueForKey(value, "histActivProf");
  }

  public Integer histAdhAgme() {
    return (Integer) storedValueForKey("histAdhAgme");
  }

  public void setHistAdhAgme(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAdhAgme from " + histAdhAgme() + " to " + value);
    }
    takeStoredValueForKey(value, "histAdhAgme");
  }

  public Integer histAffss() {
    return (Integer) storedValueForKey("histAffss");
  }

  public void setHistAffss(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAffss from " + histAffss() + " to " + value);
    }
    takeStoredValueForKey(value, "histAffss");
  }

  public Integer histAnneeDerDipl() {
    return (Integer) storedValueForKey("histAnneeDerDipl");
  }

  public void setHistAnneeDerDipl(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAnneeDerDipl from " + histAnneeDerDipl() + " to " + value);
    }
    takeStoredValueForKey(value, "histAnneeDerDipl");
  }

  public Integer histAnneeDerEtab() {
    return (Integer) storedValueForKey("histAnneeDerEtab");
  }

  public void setHistAnneeDerEtab(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAnneeDerEtab from " + histAnneeDerEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histAnneeDerEtab");
  }

  public Integer histAnneeDiplFutur() {
    return (Integer) storedValueForKey("histAnneeDiplFutur");
  }

  public void setHistAnneeDiplFutur(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAnneeDiplFutur from " + histAnneeDiplFutur() + " to " + value);
    }
    takeStoredValueForKey(value, "histAnneeDiplFutur");
  }

  public Integer histAnneeScol() {
    return (Integer) storedValueForKey("histAnneeScol");
  }

  public void setHistAnneeScol(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAnneeScol from " + histAnneeScol() + " to " + value);
    }
    takeStoredValueForKey(value, "histAnneeScol");
  }

  public Integer histAssuranceCivile() {
    return (Integer) storedValueForKey("histAssuranceCivile");
  }

  public void setHistAssuranceCivile(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAssuranceCivile from " + histAssuranceCivile() + " to " + value);
    }
    takeStoredValueForKey(value, "histAssuranceCivile");
  }

  public String histAssuranceCivileCie() {
    return (String) storedValueForKey("histAssuranceCivileCie");
  }

  public void setHistAssuranceCivileCie(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAssuranceCivileCie from " + histAssuranceCivileCie() + " to " + value);
    }
    takeStoredValueForKey(value, "histAssuranceCivileCie");
  }

  public String histAssuranceCivileNum() {
    return (String) storedValueForKey("histAssuranceCivileNum");
  }

  public void setHistAssuranceCivileNum(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAssuranceCivileNum from " + histAssuranceCivileNum() + " to " + value);
    }
    takeStoredValueForKey(value, "histAssuranceCivileNum");
  }

  public String histAutreCasExo() {
    return (String) storedValueForKey("histAutreCasExo");
  }

  public void setHistAutreCasExo(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAutreCasExo from " + histAutreCasExo() + " to " + value);
    }
    takeStoredValueForKey(value, "histAutreCasExo");
  }

  public Integer histAyantDroit() {
    return (Integer) storedValueForKey("histAyantDroit");
  }

  public void setHistAyantDroit(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histAyantDroit from " + histAyantDroit() + " to " + value);
    }
    takeStoredValueForKey(value, "histAyantDroit");
  }

  public Integer histBourse() {
    return (Integer) storedValueForKey("histBourse");
  }

  public void setHistBourse(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histBourse from " + histBourse() + " to " + value);
    }
    takeStoredValueForKey(value, "histBourse");
  }

  public NSTimestamp histDateTransfert() {
    return (NSTimestamp) storedValueForKey("histDateTransfert");
  }

  public void setHistDateTransfert(NSTimestamp value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histDateTransfert from " + histDateTransfert() + " to " + value);
    }
    takeStoredValueForKey(value, "histDateTransfert");
  }

  public Integer histDemEmpl() {
    return (Integer) storedValueForKey("histDemEmpl");
  }

  public void setHistDemEmpl(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histDemEmpl from " + histDemEmpl() + " to " + value);
    }
    takeStoredValueForKey(value, "histDemEmpl");
  }

  public Integer histDureeInt() {
    return (Integer) storedValueForKey("histDureeInt");
  }

  public void setHistDureeInt(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histDureeInt from " + histDureeInt() + " to " + value);
    }
    takeStoredValueForKey(value, "histDureeInt");
  }

  public Integer histEchBourse() {
    return (Integer) storedValueForKey("histEchBourse");
  }

  public void setHistEchBourse(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histEchBourse from " + histEchBourse() + " to " + value);
    }
    takeStoredValueForKey(value, "histEchBourse");
  }

  public String histEnsDerEtab() {
    return (String) storedValueForKey("histEnsDerEtab");
  }

  public void setHistEnsDerEtab(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histEnsDerEtab from " + histEnsDerEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histEnsDerEtab");
  }

  public Integer histForProf() {
    return (Integer) storedValueForKey("histForProf");
  }

  public void setHistForProf(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histForProf from " + histForProf() + " to " + value);
    }
    takeStoredValueForKey(value, "histForProf");
  }

  public Integer histIntEtud() {
    return (Integer) storedValueForKey("histIntEtud");
  }

  public void setHistIntEtud(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histIntEtud from " + histIntEtud() + " to " + value);
    }
    takeStoredValueForKey(value, "histIntEtud");
  }

  public String histLibelleAutEtab() {
    return (String) storedValueForKey("histLibelleAutEtab");
  }

  public void setHistLibelleAutEtab(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histLibelleAutEtab from " + histLibelleAutEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histLibelleAutEtab");
  }

  public String histLibelleDerDipl() {
    return (String) storedValueForKey("histLibelleDerDipl");
  }

  public void setHistLibelleDerDipl(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histLibelleDerDipl from " + histLibelleDerDipl() + " to " + value);
    }
    takeStoredValueForKey(value, "histLibelleDerDipl");
  }

  public String histLibelleDerEtab() {
    return (String) storedValueForKey("histLibelleDerEtab");
  }

  public void setHistLibelleDerEtab(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histLibelleDerEtab from " + histLibelleDerEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histLibelleDerEtab");
  }

  public String histLibelleProf() {
    return (String) storedValueForKey("histLibelleProf");
  }

  public void setHistLibelleProf(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histLibelleProf from " + histLibelleProf() + " to " + value);
    }
    takeStoredValueForKey(value, "histLibelleProf");
  }

  public Integer histNbInscDeug() {
    return (Integer) storedValueForKey("histNbInscDeug");
  }

  public void setHistNbInscDeug(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histNbInscDeug from " + histNbInscDeug() + " to " + value);
    }
    takeStoredValueForKey(value, "histNbInscDeug");
  }

  public Integer histNumero() {
    return (Integer) storedValueForKey("histNumero");
  }

  public void setHistNumero(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histNumero from " + histNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "histNumero");
  }

  public String histNumeroAlloc() {
    return (String) storedValueForKey("histNumeroAlloc");
  }

  public void setHistNumeroAlloc(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histNumeroAlloc from " + histNumeroAlloc() + " to " + value);
    }
    takeStoredValueForKey(value, "histNumeroAlloc");
  }

  public Integer histRedouble() {
    return (Integer) storedValueForKey("histRedouble");
  }

  public void setHistRedouble(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histRedouble from " + histRedouble() + " to " + value);
    }
    takeStoredValueForKey(value, "histRedouble");
  }

  public String histRemarques() {
    return (String) storedValueForKey("histRemarques");
  }

  public void setHistRemarques(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histRemarques from " + histRemarques() + " to " + value);
    }
    takeStoredValueForKey(value, "histRemarques");
  }

  public Integer histResteBu() {
    return (Integer) storedValueForKey("histResteBu");
  }

  public void setHistResteBu(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histResteBu from " + histResteBu() + " to " + value);
    }
    takeStoredValueForKey(value, "histResteBu");
  }

  public String histSalarie() {
    return (String) storedValueForKey("histSalarie");
  }

  public void setHistSalarie(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histSalarie from " + histSalarie() + " to " + value);
    }
    takeStoredValueForKey(value, "histSalarie");
  }

  public String histSalarieLibelle() {
    return (String) storedValueForKey("histSalarieLibelle");
  }

  public void setHistSalarieLibelle(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histSalarieLibelle from " + histSalarieLibelle() + " to " + value);
    }
    takeStoredValueForKey(value, "histSalarieLibelle");
  }

  public Integer histTeleens() {
    return (Integer) storedValueForKey("histTeleens");
  }

  public void setHistTeleens(Integer value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histTeleens from " + histTeleens() + " to " + value);
    }
    takeStoredValueForKey(value, "histTeleens");
  }

  public String histTransfert() {
    return (String) storedValueForKey("histTransfert");
  }

  public void setHistTransfert(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histTransfert from " + histTransfert() + " to " + value);
    }
    takeStoredValueForKey(value, "histTransfert");
  }

  public String histTypeFormation() {
    return (String) storedValueForKey("histTypeFormation");
  }

  public void setHistTypeFormation(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histTypeFormation from " + histTypeFormation() + " to " + value);
    }
    takeStoredValueForKey(value, "histTypeFormation");
  }

  public String histTypeRegime() {
    return (String) storedValueForKey("histTypeRegime");
  }

  public void setHistTypeRegime(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histTypeRegime from " + histTypeRegime() + " to " + value);
    }
    takeStoredValueForKey(value, "histTypeRegime");
  }

  public String histVilleAutEtab() {
    return (String) storedValueForKey("histVilleAutEtab");
  }

  public void setHistVilleAutEtab(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histVilleAutEtab from " + histVilleAutEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histVilleAutEtab");
  }

  public String histVilleDerDipl() {
    return (String) storedValueForKey("histVilleDerDipl");
  }

  public void setHistVilleDerDipl(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histVilleDerDipl from " + histVilleDerDipl() + " to " + value);
    }
    takeStoredValueForKey(value, "histVilleDerDipl");
  }

  public String histVilleDerEtab() {
    return (String) storedValueForKey("histVilleDerEtab");
  }

  public void setHistVilleDerEtab(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating histVilleDerEtab from " + histVilleDerEtab() + " to " + value);
    }
    takeStoredValueForKey(value, "histVilleDerEtab");
  }

  public String proCodeEtud() {
    return (String) storedValueForKey("proCodeEtud");
  }

  public void setProCodeEtud(String value) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
    	_EOHistorique.LOG.debug( "updating proCodeEtud from " + proCodeEtud() + " to " + value);
    }
    takeStoredValueForKey(value, "proCodeEtud");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.profiler.server.eof.EOInscDipl.TO_HISTORIQUE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_EOHistorique.LOG.isDebugEnabled()) {
      _EOHistorique.LOG.debug("adding " + object + " to toInscDipls relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "toInscDipls");
  }

  public void removeFromToInscDiplsRelationship(org.cocktail.profiler.server.eof.EOInscDipl object) {
    if (_EOHistorique.LOG.isDebugEnabled()) {
      _EOHistorique.LOG.debug("removing " + object + " from toInscDipls relationship");
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


  public static EOHistorique createHistorique(EOEditingContext editingContext, Integer etudNumero
, Integer histAccesInfo
, Integer histAdhAgme
, Integer histAffss
, Integer histAnneeScol
, Integer histAssuranceCivile
, Integer histAyantDroit
, Integer histBourse
, Integer histDemEmpl
, Integer histForProf
, Integer histIntEtud
, Integer histNumero
, Integer histResteBu
, String histSalarie
, Integer histTeleens
) {
    EOHistorique eo = (EOHistorique) EOUtilities.createAndInsertInstance(editingContext, _EOHistorique.ENTITY_NAME);    
		eo.setEtudNumero(etudNumero);
		eo.setHistAccesInfo(histAccesInfo);
		eo.setHistAdhAgme(histAdhAgme);
		eo.setHistAffss(histAffss);
		eo.setHistAnneeScol(histAnneeScol);
		eo.setHistAssuranceCivile(histAssuranceCivile);
		eo.setHistAyantDroit(histAyantDroit);
		eo.setHistBourse(histBourse);
		eo.setHistDemEmpl(histDemEmpl);
		eo.setHistForProf(histForProf);
		eo.setHistIntEtud(histIntEtud);
		eo.setHistNumero(histNumero);
		eo.setHistResteBu(histResteBu);
		eo.setHistSalarie(histSalarie);
		eo.setHistTeleens(histTeleens);
    return eo;
  }

  public static NSArray<EOHistorique> fetchAllHistoriques(EOEditingContext editingContext) {
    return _EOHistorique.fetchAllHistoriques(editingContext, null);
  }

  public static NSArray<EOHistorique> fetchAllHistoriques(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOHistorique.fetchHistoriques(editingContext, null, sortOrderings);
  }

  public static NSArray<EOHistorique> fetchHistoriques(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOHistorique.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOHistorique> eoObjects = (NSArray<EOHistorique>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static EOHistorique fetchHistorique(EOEditingContext editingContext, String keyName, Object value) {
    return _EOHistorique.fetchHistorique(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOHistorique fetchHistorique(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOHistorique> eoObjects = _EOHistorique.fetchHistoriques(editingContext, qualifier, null);
    EOHistorique eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOHistorique)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Historique that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOHistorique fetchRequiredHistorique(EOEditingContext editingContext, String keyName, Object value) {
    return _EOHistorique.fetchRequiredHistorique(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOHistorique fetchRequiredHistorique(EOEditingContext editingContext, EOQualifier qualifier) {
    EOHistorique eoObject = _EOHistorique.fetchHistorique(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Historique that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOHistorique localInstanceIn(EOEditingContext editingContext, EOHistorique eo) {
    EOHistorique localInstance = (eo == null) ? null : (EOHistorique)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
