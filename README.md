# MowItNow
Les sources sont  :

models : classes du modèle qui contient les objets suivants :

Coordonnees.
Pelouse.
PositionTondeuse.
Orientation (orientation des tondeuse nord, sud , est , ouest)
Instruction (avancer , droite , gauche)

service : services qui contiennent la logique de l'application :

UtilService : Faire le traitements sur les lignes de fichier.
InstructionService : permet de faire traiter une instruction
TondeuseService : gère le traitement des instructions sur la tondeuse.

exception : les exceptions de l'application

Les tests unitaires.

Pour executer l'ensemble des test sur l'application au niveau de terminal : 
mvn clean install 

Pour executer l'application via le terminal : 
java -jar  .\target\MowItNow-1.0-SNAPSHOT.jar "[Chemin vers le fichier]"

exemple : java -jar .\target\MowItNow-1.0-SNAPSHOT.jar "src/main/resources/fichierOk.txt"
