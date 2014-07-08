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
package org.cocktail.profiler.serveur;

import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOVlans;

import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSMutableDictionary;

public class PrintFactory {
	//	public static final String JASPER_CERTIF_SCOL = "CERTIFICATsCOL.jasper";
	public static final String JASPER_CERTIF_SCOL = "pageCertificatScol.jasper";

	public static NSData printCertificatScolarite(Application application,
			Session session, String path) {
		NSMutableDictionary parametres = new NSMutableDictionary();
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(
				EOCompte.TO_INDIVIDUS_KEY + "=%@",
				new NSArray(new Object[] { ((Session) session)
						.selectedPersonne() }));
		NSArray<EOCompte> cptEtud = EOCompte.fetchAll(session
				.defaultEditingContext(), new EOAndQualifier(
				new NSArray<EOQualifier>(
						new EOQualifier[] { EOCompte.QUAL_CPT_VALIDE_OUI,
								EOCompte.QUAL_CPT_VLAN_E, qual})), null);

		if ((cptEtud!=null)&&(cptEtud.size()>0))
			parametres.takeValueForKey(cptEtud.lastObject().cptLogin(), "login");
		else
			return null;

		//parametres.takeValueForKey("agautier", "login");
		parametres.takeValueForKey(path, "SUBREPORT_DIR");

		String reportFileName = path + JASPER_CERTIF_SCOL;
		PrintDelegate printDelegate = new PrintDelegate(session);

		NSData res = printDelegate.printNow(application, null, reportFileName,
				parametres.hashtable(), PrintDelegate.FORMATPDF, false);
		return res;

	}

}
