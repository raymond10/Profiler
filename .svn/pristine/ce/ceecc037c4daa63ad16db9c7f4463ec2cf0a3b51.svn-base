CREATE OR REPLACE PROCEDURE GRHUM.Default_Password_For_Compte
(
    cptOrdre    IN  GRHUM.COMPTE.CPT_ORDRE%TYPE,
    libelle     OUT VARCHAR2,
    pwd         OUT VARCHAR2
)
-- ************************************************************************************
-- Auteur : Cocktail
-- Création : 03/01/2010
-- Modification : 16/04/2010
-- Procedure retournant le password par defaut du compte passe en parametre
-- libelle retourne explique comment le password par defaut est généré
-- Rem : procedure a personnaliser selon la politique définie dans l'établissement
-- ************************************************************************************
IS
  cpt grhum.compte%ROWTYPE;
  nb NUMBER;
BEGIN
  pwd    :=NULL;
  libelle:=NULL;
  SELECT COUNT(*) INTO nb FROM GRHUM.compte WHERE cpt_ordre = cptOrdre;
  IF (nb>0) THEN
    SELECT * INTO cpt FROM GRHUM.compte WHERE cpt_ordre  = cptOrdre;
    -- compte Administration / Recherche  
    IF (cpt.cpt_vlan ='P' or cpt.cpt_vlan ='R') THEN
      SELECT NVL(GRHUM.CONS_PASSWD,'*'),'génération automatique du mot de passe'
      INTO pwd, libelle      
      FROM DUAL;
    END IF;
    -- compte Etudiant
    IF (cpt.cpt_vlan ='E') THEN
      SELECT NVL(UPPER(SUBSTR(e.etud_code_ine, 1, 10)), '*'),'les 10 premiers caractères du code INE en majuscules, sans la clef'
      INTO pwd, libelle
      FROM GRHUM.etudiant e, GRHUM.compte c,GRHUM.individu_ulr i
      WHERE e.no_individu = i.no_individu
      AND i.pers_id       = c.pers_id
      AND c.cpt_ordre     = cptordre;
    END IF;
    -- compte eXterieur
    IF (cpt.cpt_vlan = 'X') THEN
      SELECT NVL(param_value,'*'),'le mot de passe par défaut pour les comptes extérieurs défini dans le Système d''Information de l''établissement'
      INTO pwd, libelle
      FROM GRHUM_PARAMETRES WHERE PARAM_KEY='ANNUAIRE_EXTRANET_PASSWD';    
    END IF;
  END IF;
END;
/
