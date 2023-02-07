package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.Exceptions.Messages;
import com.hassen.models.Coordonnees;
import com.hassen.models.Instruction;
import com.hassen.models.Orientation;
import com.hassen.models.PositionTondeuse;

import java.util.logging.Logger;

public class InstructionService {

    private static final Logger LOGGER = Logger.getLogger(InstructionService.class.getName());

    /**
     * Fonction permet d'executer une instruction
     * @param positionTondeuse
     * @param coordonneesMax
     * @param instruction
     * @throws ExceptionMowItNow
     */
    public static void executerInstruction(PositionTondeuse positionTondeuse, Coordonnees coordonneesMax, Instruction instruction) throws ExceptionMowItNow {

        switch (instruction) {
            case A:
                positionTondeuse.setCoordonnees(avancerTondeuse(positionTondeuse, coordonneesMax));
                LOGGER.info(" la nouvelle position est  : " + positionTondeuse.getCoordonnees().toString()
                        + " " + positionTondeuse.getOrientation());
                break;
            case D:
                positionTondeuse.setOrientation(pivoterDroite(positionTondeuse.getOrientation()));
                LOGGER.info(" la nouvelle position est  : " + positionTondeuse.getCoordonnees().toString()
                        + " " + positionTondeuse.getOrientation());
                break;
            case G:
                positionTondeuse.setOrientation(pivoterGauche(positionTondeuse.getOrientation()));
                LOGGER.info(" la nouvelle position est  : " + positionTondeuse.getCoordonnees().toString()
                        + " " + positionTondeuse.getOrientation());
                break;
            default:
                throw new ExceptionMowItNow(Messages.INSTRUCTION_INCORRECTE);
        }

    }

    /**
     * Fonction permet de pivoter la tondeuse à droite
     * @param orientation
     * @return
     * @throws ExceptionMowItNow
     */
    public static Orientation pivoterDroite(Orientation orientation) throws ExceptionMowItNow {
        Orientation nouvelleOrientation = null;
        switch (orientation) {
            case N:
                nouvelleOrientation = Orientation.E;
                break;
            case E:
                nouvelleOrientation = Orientation.S;
                break;
            case S:
                nouvelleOrientation = Orientation.W;
                break;
            case W:
                nouvelleOrientation = Orientation.N;
                break;
            default:
                throw new ExceptionMowItNow(Messages.ORIENTATION_INCORRECTE);
        }
        return nouvelleOrientation;
    }

    /**
     * Fonction permet de pivoter la tondeuse vers la gauche
     * @param orientation
     * @return
     * @throws ExceptionMowItNow
     */
    public static Orientation pivoterGauche(Orientation orientation) throws ExceptionMowItNow {
        Orientation nouvelleOrientation = null;
        switch (orientation) {
            case N:
                nouvelleOrientation = Orientation.W;
                break;
            case W:
                nouvelleOrientation = Orientation.S;
                break;
            case S:
                nouvelleOrientation = Orientation.E;
                break;
            case E:
                nouvelleOrientation = Orientation.N;
                break;
            default:
                throw new ExceptionMowItNow(Messages.ORIENTATION_INCORRECTE);
        }
        return nouvelleOrientation;
    }

    /**
     * Fonction permet d'avancer la tondeuse
     * @param positionTondeuse
     * @param coordonneesMax
     * @return
     * @throws ExceptionMowItNow
     */
    public static Coordonnees avancerTondeuse(PositionTondeuse positionTondeuse, Coordonnees coordonneesMax) throws ExceptionMowItNow {

        Coordonnees nouvellesCoordonnees = new Coordonnees();
        switch (positionTondeuse.getOrientation()) {
            case N:
                nouvellesCoordonnees.setX(positionTondeuse.getCoordonnees().getX());
                nouvellesCoordonnees.setY(positionTondeuse.getCoordonnees().getY() + 1);
                break;
            case E:
                nouvellesCoordonnees.setX(positionTondeuse.getCoordonnees().getX() + 1);
                nouvellesCoordonnees.setY(positionTondeuse.getCoordonnees().getY());
                break;
            case S:
                nouvellesCoordonnees.setX(positionTondeuse.getCoordonnees().getX());
                nouvellesCoordonnees.setY(positionTondeuse.getCoordonnees().getY() - 1);
                break;
            case W:
                nouvellesCoordonnees.setX(positionTondeuse.getCoordonnees().getX() - 1);
                nouvellesCoordonnees.setY(positionTondeuse.getCoordonnees().getY());
                break;
            default:
                throw new ExceptionMowItNow(Messages.POSITION_INCORRECTE);
        }
        if (coordonneesMax.isHorsCoordonnesMax(nouvellesCoordonnees)) {
            return nouvellesCoordonnees;
        } else {
            return positionTondeuse.getCoordonnees();
        }
    }


}
