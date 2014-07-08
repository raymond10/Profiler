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

import org.cocktail.fwkcktlpersonne.common.metier.EOCompte;
import org.cocktail.fwkcktlpersonne.common.metier.EOQuestionSecreteDefaut;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.UtilMessages;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.foundation.ERXStringUtilities;

public class SecretQuestion extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EOCompte cptWork;

	public SecretQuestion(WOContext context) {
		super(context);
	}

	public EOCompte getCptWork() {
		if ( (cptWork != null)
				&& (!ERXEOControlUtilities.eoEquals(cptWork, ((Session) session()).getSelectedCompte())) ) {
						
						
//						Compte(((Session) session())
//				.getSelectedCompte()))) {

			
			selectedQuestion = null;
			persoQuestion = null;
			reponse = null;
			cptWork = null;

		}
		if ((cptWork == null)
				&& (((Session) session()).getSelectedCompte() != null)) {

//			setCptWork(EOCompte
//					.fetchRequiredCompte(
//							getEc(),
//							org.cocktail.profiler.server.eof.EOCompte.TO_FWKPERS__COMPTE_KEY,
//							((Session) session()).getSelectedCompte()));
			
			setCptWork(((Session) session()).getSelectedCompte().localInstanceIn(getEc()));
			
			if ((selectedQuestion == null) && (this.cptWork != null))
				setSelectedQuestion(EOQuestionSecreteDefaut
						.fetchByKeyValue(getEc(),
								EOQuestionSecreteDefaut.QS_LIBELLE_KEY,
								this.cptWork.cptQuestion()));
			if ((reponse == null) && (this.cptWork != null))
				reponse = this.cptWork.cptReponse();
			if ((persoQuestion == null) && (this.cptWork != null))
				persoQuestion = this.cptWork.cptQuestion();
		}

		return cptWork;
	}

	public void setCptWork(EOCompte cptWork) {
		this.cptWork = cptWork;

	}

	public boolean canChangePwd() {
		return getPuser().canChangePwd(
				((Session) session()).getSelectedCompte(), editedPersonne());
	}

	private String editQuestionId = ERXStringUtilities
			.safeIdentifierName("editQuestionId" + UUID.randomUUID());

	/**
	 * @return the editQuestionId
	 */
	public String editQuestionId() {
		return editQuestionId;
	}

	/**
	 * @param editQuestionId
	 *            the editQuestionId to set
	 */
	public void setEditQuestionId(String editQuestionId) {
		this.editQuestionId = editQuestionId;
	}

	private String saveOk;

	public WOActionResults editQuestion() {
		saveOk = "false";
		getCptWork();
		return null;
	}

	public String onEditQuestion() {
		return "function (open) {openAMD_" + editQuestionId + "();}";
	}

	private String questionPersoId = ERXStringUtilities
			.safeIdentifierName("questionPersoId" + UUID.randomUUID());

	/**
	 * @return the questionPersoId
	 */
	public String questionPersoId() {
		return questionPersoId;
	}

	/**
	 * @param questionPersoId
	 *            the questionPersoId to set
	 */
	public void setQuestionPersoId(String questionPersoId) {
		this.questionPersoId = questionPersoId;
	}

	private NSArray<EOQuestionSecreteDefaut> lstQuestions;

	/**
	 * @return the lstQuestions
	 */
	public NSArray<EOQuestionSecreteDefaut> lstQuestions() {
		if (lstQuestions == null)
			lstQuestions = EOQuestionSecreteDefaut.fetchAll(getEc());
//					.fetchAllQuestionSecreteDefauts(getEc());
		return lstQuestions;
	}

	/**
	 * @param lstQuestions
	 *            the lstQuestions to set
	 */
	public void setLstQuestions(NSArray<EOQuestionSecreteDefaut> lstQuestions) {
		this.lstQuestions = lstQuestions;
	}

	private EOQuestionSecreteDefaut questionOccur;

	/**
	 * @return the questionOccur
	 */
	public EOQuestionSecreteDefaut questionOccur() {
		return questionOccur;
	}

	/**
	 * @param questionOccur
	 *            the questionOccur to set
	 */
	public void setQuestionOccur(EOQuestionSecreteDefaut questionOccur) {
		this.questionOccur = questionOccur;
	}

	private EOQuestionSecreteDefaut selectedQuestion;

	/**
	 * @return the selectedQuestion
	 */
	public EOQuestionSecreteDefaut selectedQuestion() {
		return selectedQuestion;
	}

	/**
	 * @param selectedQuestion
	 *            the selectedQuestion to set
	 */
	public void setSelectedQuestion(EOQuestionSecreteDefaut selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
		//System.out.println("setSelectedQuestion:" + selectedQuestion);
	}

	private String persoQuestion;

	/**
	 * @return the persoQuestion
	 */
	public String persoQuestion() {
		return persoQuestion;
	}

	/**
	 * @param persoQuestion
	 *            the persoQuestion to set
	 */
	public void setPersoQuestion(String persoQuestion) {
		this.persoQuestion = persoQuestion;
	}

	private String reponse;

	/**
	 * @return the reponse
	 */
	public String reponse() {
		return reponse;
	}

	/**
	 * @param reponse
	 *            the reponse to set
	 */
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	private String questionReponseId = ERXStringUtilities
			.safeIdentifierName("questionReponseId" + UUID.randomUUID());
	private boolean isSavInProgress;

	/**
	 * @return the questionReponseId
	 */
	public String questionReponseId() {
		return questionReponseId;
	}

	/**
	 * @param questionReponseId
	 *            the questionReponseId to set
	 */
	public void setQuestionReponseId(String questionReponseId) {
		this.questionReponseId = questionReponseId;
	}

	public WOActionResults valide() {
		if (isSavInProgress)
			return null;
		isSavInProgress = true;

		saveOk = "false";

		if (selectedQuestion != null)
			persoQuestion = selectedQuestion.qsLibelle();

		if ((persoQuestion == null) || ("".equals(persoQuestion))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"La question est obligatoire !!");

			isSavInProgress = false;
			return null;
		}
		if ((reponse == null) || ("".equals(reponse))) {
			UtilMessages.creatMessageUtil(session(), UtilMessages.INFO_MESSAGE,
					"La réponse est obligatoire !!");

			isSavInProgress = false;
			return null;
		}

		getCptWork().setDModification(new NSTimestamp());
		getCptWork().setCptQuestion(persoQuestion);
		getCptWork().setCptReponse(reponse);

		try {
			getCptWork().editingContext().saveChanges();
		} catch (Exception e) {
			e.printStackTrace();
			UtilMessages.creatMessageUtil(session(),
					UtilMessages.ERROR_MESSAGE,
					"Erreur lors de l'enregistrement de la question secrète :\n"
							+ e.getMessage());
			isSavInProgress = false;
			return null;
		}
		saveOk = "true";
		((Session) session()).setSelectedCompte(null);
		isSavInProgress = false;
		return null;
	}

	public WOActionResults cancelChange() {
		if (getCptWork().editingContext() != null)
			getCptWork().editingContext().revert();
		return null;
	}

	private String erreurContainerid = ERXStringUtilities
			.safeIdentifierName("erreurContainerid" + UUID.randomUUID());

	private String messageid = ERXStringUtilities
			.safeIdentifierName("messageid" + UUID.randomUUID());

	public String getErreurContainerid() {
		return erreurContainerid;
	}

	public void setErreurContainerid(String erreurContainerid) {
		this.erreurContainerid = erreurContainerid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String scriptCloseDialog() {

		return "if (($('" + messageid + "'))&&(!$('" + messageid + "').visible())&&(" + saveOk
				+ "==true)) {Modalbox.hide(); }";
	}

	private String zoneEditionId = ERXStringUtilities
			.safeIdentifierName("zoneEditionId" + UUID.randomUUID());

	/**
	 * @return the zoneEditionId
	 */
	public String zoneEditionId() {
		return zoneEditionId;
	}

	/**
	 * @param zoneEditionId
	 *            the zoneEditionId to set
	 */
	public void setZoneEditionId(String zoneEditionId) {
		this.zoneEditionId = zoneEditionId;
	}

	private String questionZoneId = ERXStringUtilities
			.safeIdentifierName("questionZoneId" + UUID.randomUUID());

	/**
	 * @return the questionZoneId
	 */
	public String questionZoneId() {
		return questionZoneId;
	}

	/**
	 * @param questionZoneId
	 *            the questionZoneId to set
	 */
	public void setQuestionZoneId(String questionZoneId) {
		this.questionZoneId = questionZoneId;
	}

}