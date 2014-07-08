package org.cocktail.profiler.serveur.components;

import java.util.UUID;

import com.webobjects.appserver.WOContext;

import er.extensions.foundation.ERXStringUtilities;

public class IcalsZone extends ProfilBaseCmp {
	
	private String aucIcalId = ERXStringUtilities.safeIdentifierName("aucIcal"
			+ UUID.randomUUID());
	private String aucButtonIcalId = ERXStringUtilities
			.safeIdentifierName("aucButtonIcal" + UUID.randomUUID());
	
    public IcalsZone(WOContext context) {
        super(context);
    }
    
    public String getAucIcalId() {
		return aucIcalId;
	}

	public String getAucButtonIcalId() {
		return aucButtonIcalId;
	}
}