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

-> Nous avons implémenté toutes les méthodes nécessaires à la gestion de la calculatrice : swap, clear, drop, push, négativité, virgule etc.

-> Les PropertyChangeSupport et PropertyChangeListener et ActionListener ont été utilisés pour permettre le traitement des événements
  
  
## Ce qui n'a pas été réalisé


-> L'ajout d'un traceur de fonctions ainsi que d'un module de calcul formel

-> Le traitement des actions clavier pour l'utilisation des touches du clavier.
Ici, nous n'avons pas trouvé sur Internet de moyen d'utiliser les KeyListener dans notre cas. En effet, lors de nos recherches, nous avons trouvé des solutions permettant de traiter les événements clavier à l'aide d'extension de classes comme Applet, JPanel ou JFrame, mais nous ne sommes pas parvenus à gérer l'action des touches clavier ici. 
Nous serions d'ailleurs intéressés par une correction de cette fonctionnalité qui peut être intéressante voire essentielle au développement de projets futurs.

-> La manipulation de la fenêtre (WindowListener)

## Ce qui a été rajouté

-> Des fonctions supplémentaires (cos, sin, tan) ont été ajoutées à la calculatrice

-> La gestion des erreurs a été particulièrement bien faite puisque nous avons ajouté à l'interface graphique cette gestion des erreurs via l'apparition de messages d'erreur lors de fausses manipulations (Ex : Impossible de swap car il n'y a pas suffisamment d'opérandes)
