# ACL2021-AMU


Equipe:Oumnia, Maha, Ali, Mahdi, Moad


## Installation de Maven

### Installer Maven sur Linux :
>sudo apt update

>sudo apt install maven


### Installer Maven sur Windows :

* Sur le site officiel de Maven et t�l�charger le fichier zip Maven.

* Extractez le fichier zip.

* Appuyez sur la touche Windows, et cherchez l'option �Afficher les param�tres syst�me avanc�s�. 

* Dans la bo�te de dialogue Propri�t�s syst�me, s�lectionnez l�onglet "Avanc�" et cliquez sur le bouton "Variables d�environnement".

* Dans la bo�te de dialogue "Variables d�environnement", Variables syst�me , Cliquez sur le bouton "Nouveau..." et ajoutez une variable MAVEN_HOME et pointez la sur le fichier que vous avez d�compress�.

* Dans les variables syst�me, rechercher PATH, cliquez sur le bouton "Editer". Dans la bo�te de dialogue "Modifier la varibale d'environnement", cliquez sur le bouton "Nouveau" et ajoutez MAVEN_HOME .


### Installer Maven sur Linux :
Tapez les commandes suivantes:

* sudo apt-get remove maven2

* sudo apt-get update

* sudo apt-get install maven


### Installer Maven sur Mac :

* Aller sur le site officiel de Maven et t�l�charger le fichier Maven.

* D�compreser le fichier.

* Fixer les permissions :
    >chown -R root:wheel Downloads/apache-maven*

* Changer de place le contenu de Maven :
    >mv Downloads/apache-maven* /opt/apache-maven

* Archiver la session :
    >exit

* Ajouter Maven au PATH :
    >nano $HOME/.profile
    
    >export PATH=$PATH:/opt/apache-maven/bin
    
## Execution de l'application

```p
mvn compile
mvn exec:java -Dexec.mainClass=start.Main
```

 
