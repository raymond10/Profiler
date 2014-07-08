Template WOLIps pour le dÃ©veloppement des applications Cocktail 
-----------------------------------------------------------------------
version 0.9.0.0

rodolphe.prin@univ-lr.fr


Installation
********************
- Dossier "CktlWoTemplate" a stocker dans un des dossiers suivants :
# /Library/Application Support/WOLips/Project Templates
# YourHomeDir\Documents and Settings\Application Data\WOLips\Project Templates
# YourHomeDir\Documents and Settings\AppData\Local\WOLips\Project Templates
# ~/Library/Application Support/WOLips/Project Templates


Utilisation
********************
Dans Eclipse 3.3.1(+) / WOLips 3.3.x(+) :
- File / New project  / WOLips / WOProject from template
- Selectionner CktlWoTemplate
- Choisissez le type de projet (Framework ou Application)
- Choisissez le framework de depart
- Une fois le projet crÃ©Ã©, executez la tÃ¢che ant "run_me" dÃ©finie dans 
le fichier "ant_run_me_1st.xml" a la racine de votre projet (dans la vue Ant, ajouter le build file ant_run_me_1st.xml etr doublecliquez sur la tÃ¢che).
- Faites un refresh du projet (permet au projet d'etre construit, logiquement les erreurs disparaissent).
- Modifiez le fichier de config (nom_application.conf) situÃ© a la racine de votre projet en fonction de vos parametres
(notamment l'url du serveur saut si vous en utilisez un)
-  run / open run dialog -> lancez l'application avec le lanceur correspondant au nom de l'application
- Si votre application est une application javaclient, un "external Tools" est fourni pour lancer la partie client "<nom application>Client". 
Vous devez cependant le modifier l'argument -classpath pour rÃ©cupÃ©rer la bibliothÃ¨que ClientStd.jar (ou bien les jars WebObjects Client).

Modeles
********************
Stockez vos modeles dans le dossier Resources (si vous ne nommez pas votre modele principal du nom de votre projet, modifiez la methode mainModelName de la classe application. 


Generation des entites du modele
********************
Le dossier _EOGenTemplates contient des templates pour l'outil EOGenerator. 
Cet outil est disponible sur http://www.rubicode.com/Software/EOGenerator/ mais a priori il va etre abandonnÃ© par WOLips pour un outil basÃ© sur Velocity (qui n'est pas stabilisÃ© aujourd'hui).
Installez-le par exemple dans /Developper/EOGenerator.
Des externals tools sont fournis (a adapter) pour generer les classes metiers. 
  

Deploiement
********************
Une tache ant pour simplifier le deploiement est fournie dans le fichier build.xml :
Executez la tache Cktl_Package_me pour crÃ©er automatiquement une archive du .woa avec le nÂ° de version inclus dans le nom. Le projet compilÃ© est rÃ©cupÃ©rÃ© aprÃ¨s construction par le moteur WOlips a partir du dossier "dest.dir" (par dÃ©faut celui du projet).
Ce nÂ° de version est recupere a partir de la classe VersionMe. L'archive est stockee dans le dossier specifie dans le fichier 
build.properties (par defaut le dossier cktl_deploy dans votre workspace Eclipse).
Cette tache permet Ã©galement de nettoyer le(s) modÃ¨le(s) de votre application (suppression des lignes URL, username et password).


Classpath
********************
Le classpath est gÃ©nÃ©rÃ© automatiquement en tenant compte des options choisies.
Chaque entrÃ©e du classpath est construite Ã  partir des variables eclipse NEXT_ROOT et NEXT_LOCAL_ROOT dÃ©finies par WOLips.

NB : le classpath gÃ©nÃ©rÃ© considÃ¨re que les framework Cocktail sont installÃ©s dans 
NEXT_LOCAL_ROOT/Library/WebObjects/Applications/Frameworks/ 
et que les jars tiers (pilote jdbc, ...) sont stockes dans 
NEXT_LOCAL_ROOT/Library/WebObjects/Extensions/


Arborescence
********************
L'arborescence du projet doit Ãªtre la suivante:
src : (sources)
Components : composants Html
Client : arborescence du client
Client/src : sources de la partie JavaClient
Common/src : sources qu seront compilÃ©es a la fois pour le serveur et le client
Libraries : Jars tiers utilisÃ©s par votre application (autres que ceux des frameworks communs aux developpements Cocktail)
Resources : resources propres Ã  votre application (seront inclus dans xx.woa/Contents/Resources)
WebServerResources : resources web propres Ã  votre application (seront inclus dans xx.woa/Contents/WebServerResources) 
_sql_dist : dossier dans lequel vous pouvez stocker les diffÃ©rents scripts de mises Ã  jour sql pour chaque version de votre application (un sous-dossier par version).
javaclientbuild.xml : tache ant utilisÃ©e pour construire la partie client des projet javaclient. Cette tache est utilisÃ©e par un "External Builder" dÃ©fini dans les propriÃ©tÃ©s du projet. 

Nommage des packages Java
********************
Package de base :
org.cocktail.nom_application

Serveurs :
org.cocktail.nom_application.serveur
org.cocktail.nom_application.serveur.metier.eos


Composants html :
org.cocktail.nom_application.serveur.components

Client :
org.cocktail.nom_application.client
org.cocktail.nom_application.client.metier.eos

Interface client :
org.cocktail.nom_application.client.gui



Explications sur le fonctionnement du template
********************
Le fichier template.xml est utilisÃ© par le moteur de "Custom templates" de WOlips pour proposer les diffÃ©rentes options de crÃ©ation.
Les options rÃ©cupÃ©rÃ©es dans template.xml le sont en tant que variables Velocity (http://velocity.apache.org/engine/devel/vtl-reference-guide.html) et exploitÃ©es par le moteur de WOlips. 
Ces variables sont ensuite utilisÃ©es dans les diffÃ©rents fichiers qui composent le template.
Lorsque le projet est crÃ©Ã© Ã  partir du template, toute l'arborescence du template est recopiÃ©e. 
Les limitations du moteur de template de WOlips font qu'on a besoin d'une tache ant pour terminer l'initialisation (l'arborescence n'est pas exactement la mÃªme s'il s'agit ou non d'un projet JavaClient, les builders changent s'il s'agit d'un framework, etc.).
Donc l'initialisation finale est rÃ©alisÃ©e Ã  partir de cette tache ant et consiste essentiellement Ã  intÃ©grÃ© les bons fichiers au bon endroit en fonction du type de projet choisi. Ces fichiers sont crÃ©Ã©s Ã  partir de ceux contenus dans le dossier _templates  

Le fonctionnement de ce template est trÃ¨s dÃ©pendant de l'architecture des projets Eclipse/WOlips. Si l'architecture de l'un ou de l'autre change, le template peut ne plus fonctionner tel quel, il faudra l'adapter.       


Problemes connues
********************
- la compilation automatique de la partie javaclient ne se declenche pas toujours. Je ne sais pas d'ou ca vient... 
Dans ce cas faites un Project/Build All.




