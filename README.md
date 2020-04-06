# EscapeGame

Un escape game se joue en une heure dans une pièce fermée. Le principe est de résoudre, en équipe, une série d’énigmes scénarisées pour pouvoir sortir de la pièce dans le temps imparti.
Trois différents modes sont disponible dans cette application 

- Le mode défenseur = Tapez 1 pour lancer le mode défenseur. Ce mode permet au joueur de déterminer une combinaison de x chiffres. C'est alors que l'ordinateur doit trouver la combinaison choisi par le joueur dans la limite du nombre d'essais déterminé. 
Si l'ordinateur à trouver la combinaison de x chiffre du joueur dans la limite du nombre d'essais, le joueur à perdu. Dans le cas contraire le joueur à gagner.

- Le mode challenger = Tapez 2 pour lancer le mode challenger. Dans ce mode, l'ordinateur déterminer une combinaison de x chiffres. Le joueur doit trouver cette combinaison dans la limite du nombre d'essais. 
Si le joueur à trouver la combinaison dans la limite du nombre d'essais, le joueur à gagner. Dans le cas contraire l'ordinateur à gagner car le joueur n'aura pas trouver la combinaison dans la limite du nombre d'essais.

Le mode duel = Tapez 3 pour lancer le mode duel. Ce mode permet au joueur et à l'ordinateur de jouer tour à tour. Le premier à trouver la combinaison de l'autre à gagner.

L'application est configurable via le fichier config.properties. 
Ce fichier permet de passer en mode développeur (débug) par conséquent nous avons accès à la solution dès le début du jeu. Nous pouvons également changer la taille de la combinaison ainsi que le nombre d'essai. 


**Pre-requis** 

JDK java 8 installé sur la machine
Maven : installé sur la machine


## Compilation de l'application 

Dans un premier temps il est necessaire de cloner le projet https://github.com/flodu13/EscapeGame.git. 
Puis ouvrir l'invite de commande et se positioner où le programme réside, copier le path puis taper cd dans l'invite de commande est coller le path. 
Une fois positionner dans le répertoire approprié il faudra générer le jar via la commande mvn clean package 


## Lancement de l'application 
 
Afin de lancer l'appolication, il est nécéssaire d'exécuter le fichier jar avec la commande java -jar target\... Exemple C:\Users\iotbo\git\EscapeGame>java -jar target\my-project-name-jar-with-dependencies.jar. 
L'application se lance alors, vous devez sélectionné le mode de jeu choisi et jouer. 

