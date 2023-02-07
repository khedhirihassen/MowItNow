package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.models.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TondeuseServiceTest {

    @Test
    public void faire_executer_Instructions() throws ExceptionMowItNow {

        List<Instruction> listInstructions = new ArrayList<>();

        listInstructions.add(Instruction.G);
        listInstructions.add(Instruction.A);
        listInstructions.add(Instruction.G);
        listInstructions.add(Instruction.A);
        listInstructions.add(Instruction.G);
        listInstructions.add(Instruction.A);
        listInstructions.add(Instruction.G);
        listInstructions.add(Instruction.A);
        listInstructions.add(Instruction.A);

        Coordonnees coordonnees = new Coordonnees(1, 2);
        Coordonnees coordonneesMax = new Coordonnees(5,5);
        Pelouse pelouse = new Pelouse(coordonneesMax);
        PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.N);
        TondeuseService.executerInstructions(listInstructions,pelouse,positionTondeuse);

        assertEquals(positionTondeuse.toString(),"1 3 N");
    }

}
