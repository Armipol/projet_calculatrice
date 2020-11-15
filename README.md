# PROJET CALCULATRICE DA CUNHA_PREVOT

### Programme principal 

Le programme principal permettant de lancer l'utilisation de la calculatrice est présent sous la forme du start de la classe Controller.

## Ce qui a été réalisé

-> L'implémentation des opérations arithmétiques sur des nombres décimaux

-> Nous avons respecté le fonctionnement de la notation polonaise inverse (règles mathématiques, touche push etc.)

-> Le modèle MVC a été respecté : trois classes principales

  -> La classe Accumulateur implémente le modèle mathématique et agit sur la pile en lui          appliquant les différentes méthodes (opérations, push, swap etc.)
  
  -> La classe View permet l'affichage graphique de la calculatrice (boutons, écran) et permet de collecter les actions de l'utilisateur via des ActionEvent
  
  -> La classe Controller qui permet de faire le lien entre le modèle mathématique de l'accumulateur et le modèle graphique de la View. C'est lui qui permet les échanges d'informations entre ces deux classes et permet le lancement ainsi que le fonctionnement de la calculatrice



  
## Ce qui n'a pas été réalisé

-> L'ajout d'un traceur de fonctions ainsi que d'un module de calcul formel
