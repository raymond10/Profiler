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

import java.util.Iterator;

import com.webobjects.appserver.WOSession;
import com.webobjects.foundation.NSMutableArray;

public class UtilMessages {
	private int messageType;
	public final static int ERROR_MESSAGE = 0;
	public final static int INFO_MESSAGE = 1;
	public final static String ARRAY_MESSAGES_NAME = "ARRAY_MESSAGE_NAME";
	public final static String MESSAGE_FIELD = "message";
	public final static String MESSAGE_TYPE_FIELD = "messageType";
	private String message;
	private boolean isPersistant;

	public UtilMessages(int messageType, String message) {
		super();
		this.messageType = messageType;
		this.message = message;
		this.isPersistant = false;
	}

	public UtilMessages(int messageType, String message, boolean isPersistant) {
		super();
		this.messageType = messageType;
		this.message = message;
		this.isPersistant = isPersistant;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static void creatMessageUtil(WOSession sess, int messageType,
			String message, boolean isPersistant) {
		if (sess.objectForKey(ARRAY_MESSAGES_NAME) == null)
			sess.setObjectForKey(new NSMutableArray(), ARRAY_MESSAGES_NAME);
		NSMutableArray lstMsg = (NSMutableArray) sess
				.objectForKey(ARRAY_MESSAGES_NAME);
		lstMsg.add(new UtilMessages(messageType, message, isPersistant));
	}

	public static void creatMessageUtil(WOSession sess, int messageType,
			String message) {
		creatMessageUtil(sess, messageType, message, false);
	}

	public static void clearMessagesUtil(WOSession sess) {
		if (sess.objectForKey(ARRAY_MESSAGES_NAME) != null) {
			Iterator<UtilMessages> it = ((NSMutableArray) sess
					.objectForKey(ARRAY_MESSAGES_NAME)).iterator();
			NSMutableArray<UtilMessages> msgToDelete = new NSMutableArray<UtilMessages>();
			while (it.hasNext()) {
				UtilMessages mesg = (UtilMessages) it.next();
				if (!mesg.isPersistant)
					msgToDelete.add(mesg);
			}
			((NSMutableArray) sess.objectForKey(ARRAY_MESSAGES_NAME))
					.removeObjectsInArray(msgToDelete);
		}
	}

	public boolean isPersistant() {
		return isPersistant;
	}

	public void setPersistant(boolean isPersistant) {
		this.isPersistant = isPersistant;
	}

}
