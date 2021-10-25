# ACL2021-UNCA


Equipe:Oumnia, Maha, Ali, Mahdi, Moad


## Installation de Maven

### Installer Maven sur Linux :
>sudo apt update

>sudo apt install maven


### Installer Maven sur Windows :

* Sur le site officiel de Maven et télécharger le fichier zip Maven.

* Extractez le fichier zip.

* Appuyez sur la touche Windows, et cherchez l'option «Afficher les paramètres système avancés». 

* Dans la boîte de dialogue Propriétés système, sélectionnez l’onglet "Avancé" et cliquez sur le bouton "Variables d’environnement".

* Dans la boîte de dialogue "Variables d’environnement", Variables système , Cliquez sur le bouton "Nouveau..." et ajoutez une variable MAVEN_HOME et pointez la sur le fichier que vous avez décompressé.

* Dans les variables système, rechercher PATH, cliquez sur le bouton "Editer". Dans la boîte de dialogue "Modifier la varibale d'environnement", cliquez sur le bouton "Nouveau" et ajoutez MAVEN_HOME .


### Installer Maven sur Linux :
Tapez les commandes suivantes:

* sudo apt-get remove maven2

* sudo apt-get update

* sudo apt-get install maven


### Installer Maven sur Mac :

* Aller sur le site officiel de Maven et télécharger le fichier Maven.

* Décompreser le fichier.

* Fixer les permissions :
 chown -R root:wheel Downloads/apache-maven*

* Changer de place le contenu de Maven :
 mv Downloads/apache-maven* /opt/apache-maven

* Archiver la session :
 exit

* Ajouter Maven au PATH :
nano $HOME/.profile
    
export PATH=$PATH:/opt/apache-maven/bin
