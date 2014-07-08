CREATE OR REPLACE PROCEDURE GRHUM.Crypt_Pwd_For_Vlan
(
    pwd         IN  VARCHAR2 ,
    pwdClair    OUT VARCHAR2,
    pwdCrypt    OUT VARCHAR2 ,
    pwdLmSamba  OUT VARCHAR2,
    pwdNtSamba  OUT VARCHAR2 ,
    tCryOrdre   OUT GRHUM.COMPTE.TCRY_ORDRE%TYPE,
    vlan        IN  GRHUM.COMPTE.CPT_VLAN%TYPE
)
-- ************************************************************************************
-- Auteur : Cocktail
-- Création : 03/01/2010
-- Modification : 16/04/2010
-- Procedure qui retourne les mots de passe cryptés en fonction du VLAN
-- Rem : procedure a personnaliser selon la politique définie dans l'établissement
-- ************************************************************************************
IS
BEGIN
  pwdCrypt  :=pwd;
  pwdClair  :=pwd;
  tcryOrdre := NULL;
  IF (vlan='P' or vlan='R') THEN
    --cryptage pour les comptes PRO
    pwdCrypt  := grhum.crypt(pwd);
    tcryOrdre := 1;
  END IF;
  IF (vlan   ='E') THEN
    --cryptage pour les etudiants
    pwdCrypt  := grhum.crypt(pwd);
    tcryOrdre := 1;
    --pwdCrypt  := grhum.md5(pwd);
    --tcryOrdre := 2;
  END IF;
  --Vlan pour lequel le password clair est null
  IF (vlan='P' or vlan='R') THEN
    pwdClair:=NULL;
  END IF;
  pwdNtSamba := grhum.Crypt_Nt_Samba(pwd);
  pwdLmSamba := grhum.Crypt_Lm_Samba(pwd);
END;