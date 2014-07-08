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
package org.cocktail.profiler.serveur.finder;

import org.cocktail.fwkcktlpersonne.common.metier.EOPhotosEmployes;
import org.cocktail.fwkcktlpersonne.common.metier.EOPhotosEtudiantsGrhum;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public class FinderPhoto {

	/**
	 * trouver le photo d'un individu
	 */
	public static EOGenericRecord photoForIndividu(EOEditingContext ec,
			Integer ind) {
		//on cherche en first dans la table photo_employe
		EOQualifier qual = EOQualifier.qualifierWithQualifierFormat(
				EOPhotosEmployes.NO_INDIVIDU_KEY + " = %@", new NSArray(ind));
		EOFetchSpecification fs = new EOFetchSpecification(
				EOPhotosEmployes.ENTITY_NAME, qual, null);
		EOGenericRecord retour = null;

		retour = (EOGenericRecord) ec.objectsWithFetchSpecification(fs)
				.lastObject();

		if (retour == null) {
			qual = EOQualifier.qualifierWithQualifierFormat(
					EOPhotosEtudiantsGrhum.NO_INDIVIDU_KEY + " = %@",
					new NSArray(ind));
			fs = new EOFetchSpecification(EOPhotosEtudiantsGrhum.ENTITY_NAME,
					qual, null);

			retour = (EOGenericRecord) ec.objectsWithFetchSpecification(fs)
					.lastObject();

		}
		return retour;
	}
}
