/*
 * Copyright COCKTAIL (www.cocktail.org), 1995, 2011 This software
 * is governed by the CeCILL license under French law and abiding by the
 * rules of distribution of free software. You can use, modify and/or
 * redistribute the software under the terms of the CeCILL license as
 * circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * As a counterpart to the access to the source code and rights to copy, modify
 * and redistribute granted by the license, users are provided only with a
 * limited warranty and the software's author, the holder of the economic
 * rights, and the successive licensors have only limited liability. In this
 * respect, the user's attention is drawn to the risks associated with loading,
 * using, modifying and/or developing or reproducing the software by the user
 * in light of its specific status of free software, that may mean that it
 * is complicated to manipulate, and that also therefore means that it is
 * reserved for developers and experienced professionals having in-depth
 * computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling
 * the security of their systems and/or data to be ensured and, more generally,
 * to use and operate it in the same conditions as regards security. The
 * fact that you are presently reading this means that you have had knowledge
 * of the CeCILL license and that you accept its terms.
 */
package org.cocktail.profiler.serveur.components;

import java.math.BigDecimal;

import org.cocktail.fwkcktlwebapp.server.CktlDataResponse;
import org.cocktail.profiler.server.eof.EOScolExamenEntete;
import org.cocktail.profiler.server.eof.EOScolInscriptionEtudiant;
import org.cocktail.profiler.server.eof.EOScolInscriptionExamen;
import org.cocktail.profiler.server.eof.EOScolMaquetteEc;
import org.cocktail.profiler.server.eof.EOScolMaquetteRepartitionEc;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.PrintFactory;
import org.cocktail.profiler.serveur.ProfilerParamManager;
import org.cocktail.profiler.serveur.Session;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXQ;

public class Scolarite extends ProfilBaseCmp 
{

	private static final long serialVersionUID = -4123490149498552276L;
	protected boolean erreurIdentification;
	protected EOScolInscriptionEtudiant itemInscription;
	protected EOEnterpriseObject itemRepartEc;
	protected EOEnterpriseObject itemIscriptionExam;

	public NSMutableArray<EOScolInscriptionExamen> itemListeInscriptionExam;
	public EOScolInscriptionExamen itemInscriptionExam;
	public int index;

	public static final String ECHEC = "red";



	private boolean _rowFlip; // used to alternate colors
	
	public Scolarite(WOContext context)
	{
		super(context);
		erreurIdentification = false;
	}

	public boolean erreurIdentification()
	{
		return erreurIdentification;
	}

	public void setErreurIdentification(boolean newErreurIdentification)
	{
		erreurIdentification = newErreurIdentification;
	}

	public boolean canPrintCertif() {
		return ((Application) application()).config().booleanForKey(
				Application.CAN_PRINT_CERTIF_SCOL)
				&& (((Session) session()).lstInscDipl() != null)
				&& (((Session) session()).lstInscDipl().size() > 0);
	}


	public WOActionResults onImprimer() {
		String path = WOApplication.application().resourceManager()
		.pathURLForResourceNamed(
				"reports/" + PrintFactory.JASPER_CERTIF_SCOL, null,
				null).getPath();
		path = path.substring(0, path
				.lastIndexOf(PrintFactory.JASPER_CERTIF_SCOL));

		NSData data = PrintFactory.printCertificatScolarite(
				(Application) application(), (Session) session(), path);

		if (data == null) {
			// return ((Session) session()).afficherErreur(new Exception("Impossible d'imprimer le bulletin " + fileName));
		}
		String fileName = "certificat.pdf";

		CktlDataResponse resp = new CktlDataResponse();
		if (data != null) {
			resp.setContent(data, CktlDataResponse.MIME_PDF);
			resp.setFileName(fileName);
		} else {
			resp.setContent("");
			resp.setHeader("0", "Content-Length");
		}
		return resp.generateResponse();
	}

	public EOScolInscriptionEtudiant itemInscription()
	{
		return itemInscription;
	}

	public void setItemInscription(EOScolInscriptionEtudiant newItemInscription)
	{
		itemInscription = newItemInscription;
	}

	public WOComponent selectionDiplome()
	{
		((Session)session()).setInscriptionSelected(itemInscription());
		return null;
	}

	public EOEditingContext localEContext()
	{
		return session().defaultEditingContext();
	}

	public String nomEcItem()
	{
		int i;
		for(i = 0; i < itemListeInscriptionExam.count() && (itemListeInscriptionExam.count() == 0 || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete() == null || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc() == null); i++);
		if(i == itemListeInscriptionExam.count())
			return null;
		else
			return ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc().mecLibelle();
		// Le code ci-dessous est pour renvoyer le code de l'EC	
//		return ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc().mecCode()
	}
	
	public String codeEcItem()
	{
		int i;
		for(i = 0; i < itemListeInscriptionExam.count() && (itemListeInscriptionExam.count() == 0 || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete() == null || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc() == null); i++);
		if(i == itemListeInscriptionExam.count())
			return null;
		else
			// Le code ci-dessous est pour renvoyer le coeff de l'EC
			return ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc().mecCode();
	}
	public String sessionEcItem()
	{
		int i;
		for(i = 0; i < itemListeInscriptionExam.count() && (itemListeInscriptionExam.count() == 0 || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete() == null || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc() == null); i++);
		if(i == itemListeInscriptionExam.count())
			return null;
		else
			// Le code ci-dessous est pour renvoyer le coeff de l'EC
			return ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc().mecSession1();
	}
	
	public String coeffEcItem()
	{
		EOScolMaquetteRepartitionEc repartEC;
		int i;
		for(i = 0; i < itemListeInscriptionExam.count() && (itemListeInscriptionExam.count() == 0 || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete() == null || ((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc() == null); i++);
		if(i == itemListeInscriptionExam.count())
			return null;
		else
			// Le code ci-dessous est pour renvoyer le coeff de l'EC
			repartEC = EOScolMaquetteRepartitionEc.fetchRequiredScolMaquetteRepartitionEc(localEContext(), EOScolMaquetteRepartitionEc.MEC_KEY_KEY,
					((EOScolInscriptionExamen)itemListeInscriptionExam.objectAtIndex(i)).toScolExamenEntete().scolMaquetteEc().mecKey());
			return repartEC.mrecCoefficient().toString();
	}
	
	public String backgroundColorForRow() {
		_rowFlip = !_rowFlip;
		if (_rowFlip)
			return "pair";
		else
			return "impair";
	}

	public NSMutableArray<NSMutableArray<EOScolInscriptionExamen>> listeInscriptionExamen()
	{
		NSMutableArray<EOScolInscriptionExamen> liste = new NSMutableArray<EOScolInscriptionExamen>();
		NSMutableArray<EOQualifier> args = new NSMutableArray<EOQualifier>();
		args.addObject(EOQualifier.qualifierWithQualifierFormat("ieentValidite = %@", new NSArray<String>("O")));
		args.addObject(EOQualifier.qualifierWithQualifierFormat("idiplNumero = %@", new NSArray<Long>(((Session)session()).inscriptionSelected().idiplNumero())));
		args.addObject(EOQualifier.qualifierWithQualifierFormat("toScolExamenEntete.eentPubliable = %@", new NSArray<String>("O")));
		args.addObject(EOQualifier.qualifierWithQualifierFormat("toScolExamenEntete.eentTraite = %@", new NSArray<Integer>(new Integer(4))));
		liste.addObjectsFromArray(EOScolInscriptionExamen.fetchScolInscriptionExamens(localEContext(), new EOAndQualifier(args), null));
		
		NSMutableArray<EOSortOrdering> sort = new NSMutableArray<EOSortOrdering>();
		if (!isScolariteDisplayCustomed()){
			sort.addObject(EOSortOrdering.sortOrderingWithKey("toScolExamenEntete.eentSemestre", EOSortOrdering.CompareDescending));
			sort.addObject(EOSortOrdering.sortOrderingWithKey("mecKey", EOSortOrdering.CompareAscending));
			sort.addObject(EOSortOrdering.sortOrderingWithKey("toScolExamenEntete.eentSession", EOSortOrdering.CompareAscending));
			sort.addObject(EOSortOrdering.sortOrderingWithKey("toScolExamenEntete.eentEpreuve", EOSortOrdering.CompareAscending));
//			LRLog.trace("liste = " + liste.valueForKey("mecKey"));
		} else {
			sort.addObject(EOSortOrdering.sortOrderingWithKey("toScolExamenEntete.eentSemestre", EOSortOrdering.CompareDescending));
			/* Ci-dessous la version sans risque */
			sort.addObject(EOSortOrdering.sortOrderingWithKey(ERXQ.keyPath(EOScolInscriptionExamen.TO_SCOL_EXAMEN_ENTETE_KEY, EOScolExamenEntete.SCOL_MAQUETTE_EC_KEY, EOScolMaquetteEc.MEC_CODE_KEY), EOSortOrdering.CompareAscending));
		}
		EOSortOrdering.sortArrayUsingKeyOrderArray(liste, sort);
		
		NSMutableArray<NSMutableArray<EOScolInscriptionExamen>> listeEcExam = new NSMutableArray<NSMutableArray<EOScolInscriptionExamen>>();
		Number mecKey = null;
		NSMutableArray<EOScolInscriptionExamen> tmp = new NSMutableArray<EOScolInscriptionExamen>();
		for(int i = 0; i < liste.count(); i++)
		{
			EOScolInscriptionExamen inscriptExam = (EOScolInscriptionExamen)liste.objectAtIndex(i);
			if(mecKey == null)
				mecKey = inscriptExam.mecKey();
			if(mecKey.intValue() == inscriptExam.mecKey().intValue())
			{
				if(inscriptExam != null && tmp.indexOfIdenticalObject(inscriptExam) == -1)
					tmp.addObject(inscriptExam);
			} else {
				if(tmp.count() > 0)
					listeEcExam.add(new NSMutableArray<EOScolInscriptionExamen>(tmp));
				tmp.removeAllObjects();
				if(inscriptExam != null && tmp.indexOfIdenticalObject(inscriptExam) == -1)
					tmp.addObject(inscriptExam);
				mecKey = inscriptExam.mecKey();
			}
		}

		if(tmp.count() > 0)
			listeEcExam.add(new NSMutableArray<EOScolInscriptionExamen>(tmp));
		return listeEcExam;
	}


	/**
	 * @return couleur pour savoir si l'EC est valid�e ou non
	 * 
	 * XP 05/06
	 */
	public String couleurNote()
	{
		if(itemInscriptionExam.ieentNoteDefinitive() == null)
			return "";
		BigDecimal base = itemInscriptionExam.toScolExamenEntete().eentNoteBase();
		BigDecimal moyenne = base.divide(BigDecimal.valueOf(2), 3);
		if(moyenne.compareTo(itemInscriptionExam.ieentNoteDefinitive()) > 0)
			return ECHEC;
		else
			return "";
	}

	public String typeSemestre()
	{
		if(itemInscriptionExam == null || itemInscriptionExam.toScolExamenEntete() == null || itemInscriptionExam.toScolExamenEntete().eentSemestre() == null)
			return null;
		if(itemInscriptionExam.toScolExamenEntete().eentSemestre().intValue() % 2 == 0)
			return "Pair";
		else
			return "Impair";
	}
	
	public String numeroSemestre()
	{
		Integer annee;
		Integer semestre;
		
		if(itemInscriptionExam == null || itemInscriptionExam.toScolExamenEntete() == null || itemInscriptionExam.toScolExamenEntete().eentSemestre() == null)
			return null;
		
		annee = Integer.parseInt(((Session)session()).inscriptionSelected().idiplAnneeSuivie().toString());
		if(itemInscriptionExam.toScolExamenEntete().eentSemestre().intValue() % 2 == 0){
			semestre = 2 * annee;
		}
		else {
			semestre = (2 * annee) - 1;
		}
		return semestre.toString();
	}
	
	
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que l'utilisateur
	 * puisse accéder à un affichage de la Scolarité "customisé".
	 */
	public boolean isScolariteDisplayCustomed(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_SCOLARITE_AFFICHAGECUSTOM_ACTIVE) ){
			return true;
		}
		return false;
	}
	
	public String affichageMecSession(){
		String message = "return confirm('";
		message += sessionEcItem();
		message += "');";
		return message;
	}

}
