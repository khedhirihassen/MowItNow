package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.Exceptions.Messages;
import com.hassen.models.*;

import java.util.ArrayList;
import java.util.List;

public class UtilService {

    public static final String CHAINE_ESPACE = " ";

    /**
     * Fonction permet d'extraire les coordonnées du coin supérieur droit de la pelouse
     * @param ligneCoordonnees
     * @return
     */
    public static Pelouse getlimitePelouse(String ligneCoordonnees) throws ExceptionMowItNow {
        try {
            String[] coordonneesMax = ligneCoordonnees.split(CHAINE_ESPACE);
            return new Pelouse(new Coordonnees(Integer.valueOf(coordonneesMax[0]), Integer.valueOf(coordonneesMax[1])));
        } catch (Exception e){
            throw new ExceptionMowItNow(Messages.ERREUR_FICHIER_INEXISTANT);
        }
    }

    /**
     * Fonction permet de donner la position initiale de la tondeuse, ainsi que son orientation
     * @param ligneTondeuse
     * @return
     */
    public static PositionTondeuse getPositionTondeuse(String ligneTondeuse) throws ExceptionMowItNow {
        try {
            String[] position = ligneTondeuse.split(CHAINE_ESPACE);
            Coordonnees coordonneesTondeuse = new Coordonnees(Integer.valueOf(position[0]), Integer.valueOf(position[1]));
            Orientation orientation = Orientation.valueOf(position[2]);
            return new PositionTondeuse(coordonneesTondeuse,orientation);
        } catch (Exception e){
            throw new ExceptionMowItNow(Messages.ERREUR_DONNEES_INCORRECTES);
        }

    }

    /**
     * Fonction permet d'extraire une série d'instructions ordonnant la tondeuse d'explorer la pelouse
     * @param ligneInstruction
     * @return
     */
    public static List<Instruction> getInstructionsList(String ligneInstruction) throws ExceptionMowItNow {

        try {
            List<Instruction> listInstruction = new ArrayList<>();
            for (char instruction : ligneInstruction.toCharArray()) {
                listInstruction.add(Instruction.valueOf(String.valueOf(instruction)));
            }
            return listInstruction;
        } catch (Exception e){
            throw new ExceptionMowItNow(Messages.ERREUR_DONNEES_INCORRECTES);
        }
    }


}
