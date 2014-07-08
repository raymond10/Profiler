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

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.swing.ImageIcon;

import org.cocktail.fwkcktlpersonne.common.metier.EOIndividu;
import org.cocktail.fwkcktlpersonne.common.metier.EOPhotosEmployes;
import org.cocktail.fwkcktlpersonne.common.metier.EOPhotosEtudiantsGrhum;
import org.cocktail.profiler.serveur.Application;
import org.cocktail.profiler.serveur.ProfilerUser;
import org.cocktail.profiler.serveur.Session;
import org.cocktail.profiler.serveur.UtilMessages;
import org.cocktail.profiler.serveur.finder.FinderPhoto;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSPathUtilities;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXStringUtilities;

public class Photo extends ProfilBaseCmp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int heightPhoto = 130;

	public Photo(WOContext context) {
		super(context);
	}

	/**
	 * @return the getPhotoDatas
	 */
	public NSData getPhotoDatas() {
		if (((Session) session()).getPhoto() == null) {
			if ((editedPersonne() != null) && (editedPersonne().isIndividu())) {
				((Session) session()).setPhoto(FinderPhoto.photoForIndividu(
						getEc(), new Integer(editedPersonne().getNumero())));
			}
		}
		//System.out.println(((Session) session()).getPhoto());
		if (((Session) session()).getPhoto() != null) {
			return (NSData) ((Session) session()).getPhoto().valueForKey(
					EOPhotosEmployes.DATAS_PHOTO_KEY);
		}
		
		if (((Session) session()).getPhoto() != null && ((EOIndividu)editedPersonne()).isPersonnel() ) {
			return (NSData) ((Session) session()).getPhoto().valueForKey(
					EOPhotosEmployes.DATAS_PHOTO_KEY);
		}
		
		if (((Session) session()).getPhoto() != null && ((EOIndividu)editedPersonne()).isEtudiant() ) {
			return (NSData) ((Session) session()).getPhoto().valueForKey(
					EOPhotosEtudiantsGrhum.DATAS_PHOTO_KEY);
		}
		return null;
	}

	public boolean canChangePhoto() {
		return getPuser().canChangePhoto(editedPersonne());
	}

	public NSData datasUploaded;

	/**
	 * @return the datasUploaded
	 */
	public NSData datasUploaded() {
		return datasUploaded;
	}

	/**
	 * @param datasUploaded
	 *            the datasUploaded to set
	 */
	public void setDatasUploaded(NSData datasUploaded) {
		this.datasUploaded = datasUploaded;
	}

	public String photoFileName;

	/**
	 * @return the photoFileName
	 */
	public String photoFileName() {
		return photoFileName;
	}

	/**
	 * @param photoFileName
	 *            the photoFileName to set
	 */
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String photoMimeType;

	/**
	 * @return the photoMimeType
	 */
	public String photoMimeType() {
		return photoMimeType;
	}

	/**
	 * @param photoMimeType
	 *            the photoMimeType to set
	 */
	public void setPhotoMimeType(String photoMimeType) {
		this.photoMimeType = photoMimeType;
	}

	private String aucPhotoId = ERXStringUtilities
			.safeIdentifierName("aucPhotoId" + UUID.randomUUID());

	/**
	 * @return the aucPhotoId
	 */
	public String aucPhotoId() {
		return aucPhotoId;
	}

	/**
	 * @param aucPhotoId
	 *            the aucPhotoId to set
	 */
	public void setAucPhotoId(String aucPhotoId) {
		this.aucPhotoId = aucPhotoId;
	}

	public WOActionResults validPhoto() {
		//System.out.println(photoFileName);
		// Get just the name for the uploaded file from aFileName.
		String fileName = NSPathUtilities.lastPathComponent(photoFileName);
		//System.out.println(photoFileName);
		//System.out.println("MimeType: '" + photoMimeType + "'");
		// Create the output path for the file on the application server
		Session sess = ((Session) session());
		if ((fileName != null) && (fileName.length() > 0)) {
			//System.out.println("MimeType: '" + photoMimeType + "'");			

			//resize de la photo si besoin
			ImageIcon original = new ImageIcon(datasUploaded.bytes());
			if (original.getIconHeight() == -1) {
				UtilMessages.creatMessageUtil(session(),
						UtilMessages.ERROR_MESSAGE, "Le format "
								+ photoMimeType
								+ " n'est pas pris en compte pour la photo !");

				return null;
			}
			int newWidth, newHeight;
			ImageIcon image = null;
			if (original.getIconHeight() <= heightPhoto) {//Si l'image est petite, on ne fait rien.
				image = original;
			} else {
				double ratio = 1.0;

				ratio = (double) (heightPhoto)
						/ (double) original.getIconHeight();
				newHeight = heightPhoto;
				newWidth = (int) (original.getIconWidth() * ratio);

				image = new ImageIcon(original.getImage().getScaledInstance(
						newWidth, newHeight, Image.SCALE_SMOOTH));
				original = null;
			}
			System.gc();
			/* On crée la nouvelle image */
			BufferedImage bufImage = new BufferedImage(image.getIconWidth(),
					image.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			bufImage.getGraphics().drawImage(image.getImage(), 0, 0, null);
			ByteArrayOutputStream byteImg = new ByteArrayOutputStream();
			JPEGImageEncoder encImg = JPEGCodec.createJPEGEncoder(byteImg);
			try {
				encImg.encode(bufImage);
			} catch (ImageFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			datasUploaded = new NSData(byteImg.toByteArray());

			try {
				byteImg.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (sess.getPhoto() == null) {
				if (ProfilerUser.isEtudiant(getEditedIndividu())) {
					sess.setPhoto(new EOPhotosEtudiantsGrhum());
					((EOPhotosEtudiantsGrhum) sess.getPhoto())
							.setDatePrise(new com.webobjects.foundation.NSTimestamp());
					((EOPhotosEtudiantsGrhum) sess.getPhoto())
							.setDatasPhoto(datasUploaded);
					// on alimente la primaryKey pour eviter que WO essaie de creer une nouvelle PK
					((EOPhotosEtudiantsGrhum) sess.getPhoto())
							.setNoIndividu(new Integer(editedPersonne()
									.getNumero()));
				} else {
					sess.setPhoto(new EOPhotosEmployes());
					((EOPhotosEmployes) sess.getPhoto())
							.setDatePrise(new com.webobjects.foundation.NSTimestamp());
					((EOPhotosEmployes) sess.getPhoto())
							.setDatasPhoto(datasUploaded);
					// on alimente la primaryKey pour eviter que WO essaie de creer une nouvelle PK
					((EOPhotosEmployes) sess.getPhoto())
							.setNoIndividu(new Integer(editedPersonne()
									.getNumero()));
				}

				getEc().insertObject(sess.getPhoto());
			} else {
				if (sess.getPhoto() instanceof EOPhotosEmployes) {
					((EOPhotosEmployes) sess.getPhoto())
							.setDatasPhoto(datasUploaded);
					((EOPhotosEmployes) sess.getPhoto())
							.setDatePrise(new com.webobjects.foundation.NSTimestamp());
				}
				if (sess.getPhoto() instanceof EOPhotosEtudiantsGrhum) {
					((EOPhotosEtudiantsGrhum) sess.getPhoto())
							.setDatasPhoto(datasUploaded);
					((EOPhotosEtudiantsGrhum) sess.getPhoto())
							.setDatePrise(new com.webobjects.foundation.NSTimestamp());
				}
			}
			editedPersonne().setPersIdModification(getPuser().getPersId());
			getEditedIndividu().setIndPhoto("O");

		} else {
			System.out.println("No File Uploaded");
		}
		try {

			save();
		} catch (Exception e) {
			sess.setPhoto(null);
			e.printStackTrace();
		}
		return null;
	}

	public WOActionResults deletePhoto() {
		Session sess = ((Session) session());
		if (sess.getPhoto() == null || editedPersonne() == null)
			return null;

		EOGenericRecord photo = sess.getPhoto();
		sess.setPhoto(null);
		photo.editingContext().deleteObject(photo);

		getEditedIndividu().setIndPhoto("N");
		try {
			save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String changePhotoId = ERXStringUtilities
			.safeIdentifierName("changePhotoId" + UUID.randomUUID());

	/**
	 * @return the changePhotoId
	 */
	public String changePhotoId() {
		return changePhotoId;
	}

	/**
	 * @param changePhotoId
	 *            the changePhotoId to set
	 */
	public void setChangePhotoId(String changePhotoId) {
		this.changePhotoId = changePhotoId;
	}

	public String onClickChangePhoto() {
		return "function (open) {openAMD_" + changePhotoId + "();}";
	}

	private String aulChangementId = ERXStringUtilities
			.safeIdentifierName("aulChangementId" + UUID.randomUUID());

	/**
	 * @return the aulChangementId
	 */
	public String AulChangementId() {
		return aulChangementId;
	}

	/**
	 * @param aulChangementId
	 *            the aulChangementId to set
	 */
	public void setAulChangementId(String aulChangementId) {
		this.aulChangementId = aulChangementId;
	}

	public boolean canDeletePhoto() {

		if (canChangePhoto())
			return "TRUE".equals(((Application) application()).config()
					.valueForKey("CAN_DELETE_PHOTO"));
		return false;
	}

	public NSTimestamp dateModifPhoto() {
		return (NSTimestamp) ((Session) session()).getPhoto().valueForKey(
				EOPhotosEmployes.DATE_PRISE_KEY);
	}

	private String erreurContainerid = ERXStringUtilities
			.safeIdentifierName("erreurContainerid" + UUID.randomUUID());

	/**
	 * @return the erreurContainerid
	 */
	public String erreurContainerid() {
		return erreurContainerid;
	}

	/**
	 * @param erreurContainerid
	 *            the erreurContainerid to set
	 */
	public void setErreurContainerid(String erreurContainerid) {
		this.erreurContainerid = erreurContainerid;
	}

	private String messageid = ERXStringUtilities
			.safeIdentifierName("messageid" + UUID.randomUUID());

	/**
	 * @return the messageid
	 */
	public String messageid() {
		return messageid;
	}

	/**
	 * @param messageid
	 *            the messageid to set
	 */
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

}