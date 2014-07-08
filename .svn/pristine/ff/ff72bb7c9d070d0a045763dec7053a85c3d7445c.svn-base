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

import java.util.UUID;

import org.cocktail.fwkcktlpersonne.common.metier.EOTypeTel;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerParamManager;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.foundation.ERXStringUtilities;

public class TelZone extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String aucTelId = ERXStringUtilities.safeIdentifierName("aucTel"
			+ UUID.randomUUID());
	private String aucButtonTelId = ERXStringUtilities
			.safeIdentifierName("aucButtonTel" + UUID.randomUUID());
	private String aucTriggerTelId = ERXStringUtilities
			.safeIdentifierName("aucTriggerTel" + UUID.randomUUID());

	public static final String FORBIDDEN_TEL_KEY = "FORBIDDEN_TYPE_TEL";

	public TelZone(WOContext context) {
		super(context);
		setLstEditZones(new NSArray<String>(new String[] { aucTelId,
				aucButtonTelId }));
	}

	public String getAucTelId() {
		return aucTelId;
	}

	public String getAucButtonTelId() {
		return aucButtonTelId;
	}

	public String getAucTriggerTelId() {
		return aucTriggerTelId;
	}

	public boolean canEditTel() {
		return getPuser().canEditTelephone(editedPersonne());
	}

	private EOQualifier qualTypeTel;

	/**
	 * @return the qualTypeTel
	 */
	public EOQualifier qualTypeTel() {
		if (qualTypeTel == null) {
			String forbiddenTelStr = ((Application) application()).config().stringForKey(FORBIDDEN_TEL_KEY);
			String[] forbiddenTel = (forbiddenTelStr !=null) ?  forbiddenTelStr.split(",") : new String[]{};
				
			String qualStr = EOTypeTel.D_CREATION_KEY + " != nil";
			NSMutableArray<Object> val = new NSMutableArray<Object>();
			if (!getPuser().haveAdminRight())
				//si c'est pas un administrateur, on limite les type tel gérés
				if ((forbiddenTel != null) && (forbiddenTel.length > 0)) {
					for (String type : forbiddenTel) {
						qualStr += " AND " + EOTypeTel.C_TYPE_TEL_KEY + "!=%s ";
						val.addObject(type);
					}
				}
			qualTypeTel = EOQualifier
					.qualifierWithQualifierFormat(qualStr, val);
		}
		return qualTypeTel;
	}

	/**
	 * @param qualTypeTel
	 *            the qualTypeTel to set
	 */
	public void setQualTypeTel(EOQualifier qualTypeTel) {
		this.qualTypeTel = qualTypeTel;
	}

	@Override
	public WOActionResults save() throws Exception {
		super.save();
		getEc().invalidateAllObjects();
		return null;
	}
	/**
	 * AJout d'un paramètre dans la table Grhum.paramètre pour que les téléphones
	 * soient seulement en mode affichage.
	 */
	public boolean isTelephoneReadOnlyEnabled(){
		if (myApp().config().booleanForKey(ProfilerParamManager.PROFILER_TEL_READONLY_ACTIVE) ){
			return true;
		}
		return false;
	}

}