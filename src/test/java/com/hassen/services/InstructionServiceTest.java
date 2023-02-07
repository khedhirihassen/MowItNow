package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.models.Coordonnees;
import com.hassen.models.Instruction;
import com.hassen.models.Orientation;
import com.hassen.models.PositionTondeuse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InstructionServiceTest {

    @Test
    public void faire_pivoter_droite() throws ExceptionMowItNow {

        Orientation nouvelleOrientation = InstructionService.pivoterDroite(Orientation.N);
        assertEquals(nouvelleOrientation,Orientation.E);

        nouvelleOrientation = InstructionService.pivoterDroite(Orientation.E);
        assertEquals(nouvelleOrientation,Orientation.S);

        nouvelleOrientation = InstructionService.pivoterDroite(Orientation.S);
        assertEquals(nouvelleOrientation,Orientation.W);

        nouvelleOrientation = InstructionService.pivoterDroite(Orientation.W);
        assertEquals(nouvelleOrientation,Orientation.N);

    }

    @Test
    public void faire_pivoter_gauche() throws ExceptionMowItNow {

        Orientation nouvelleOrientation = InstructionService.pivoterGauche(Orientation.N);
        assertEquals(nouvelleOrientation,Orientation.W);

        nouvelleOrientation = InstructionService.pivoterGauche(Orientation.W);
        assertEquals(nouvelleOrientation,Orientation.S);

        nouvelleOrientation = InstructionService.pivoterGauche(Orientation.S);
        assertEquals(nouvelleOrientation,Orientation.E);

        nouvelleOrientation = InstructionService.pivoterGauche(Orientation.E);
        assertEquals(nouvelleOrientation,Orientation.N);

    }

    @Test
    public void faire_avancer() throws ExceptionMowItNow {

        Coordonnees coordonneesMax = new Coordonnees(5,5);
        Coordonnees coordonnees = new Coordonnees(1,3);
        PositionTondeuse positionTondeuse = new PositionTondeuse(new Coordonnees(1,2),Orientation.N);
        Coordonnees nouvelleCoordonnees = InstructionService.avancerTondeuse(positionTondeuse,coordonneesMax);

        assertEquals(nouvelleCoordonnees,coordonnees);

    }

    @Test
    public void faire_executer_instruction() throws ExceptionMowItNow {

        Coordonnees coordonnesMax = new Coordonnees(5, 5);
        Coordonnees coordonnees = new Coordonnees(1, 3);
        PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.N);
        InstructionService.executerInstruction(positionTondeuse, coordonnesMax, Instruction.D);

        assertEquals(positionTondeuse.getCoordonnees(),coordonnees);

        assertEquals(positionTondeuse.getOrientation(),Orientation.E);

    }

}
