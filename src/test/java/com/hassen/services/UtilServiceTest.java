package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.models.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilServiceTest {

    @Test
    public void verifier_limite_Pelouse() throws ExceptionMowItNow {

        Pelouse pelouse = UtilService.getlimitePelouse("5 5");
        Pelouse pelouseOk = new Pelouse(new Coordonnees(5,5));
        Pelouse pelouseKo = new Pelouse(new Coordonnees(6,6));

        assertTrue(pelouse.equals(pelouseOk));
        assertFalse(pelouse.equals(pelouseKo));

    }

    @Test
    public void verifier_position_tondeuse() throws ExceptionMowItNow {

        PositionTondeuse positionTondeuse = UtilService.getPositionTondeuse("1 2 N");
        PositionTondeuse positionTondeuseOk = new PositionTondeuse(new Coordonnees(1,2), Orientation.N);
        PositionTondeuse positionTondeuseKo = new PositionTondeuse(new Coordonnees(1,2), Orientation.S);

        assertTrue(positionTondeuse.equals(positionTondeuseOk));
        assertFalse(positionTondeuse.equals(positionTondeuseKo));

    }

    @Test
    public void verifier_instructions() throws ExceptionMowItNow {

        List<Instruction> instructionsAttendu = new ArrayList<>();
        instructionsAttendu.add(Instruction.A);
        instructionsAttendu.add(Instruction.D);
        instructionsAttendu.add(Instruction.G);
        instructionsAttendu.add(Instruction.A);

        assertEquals(UtilService.getInstructionsList("ADGA"),instructionsAttendu);

    }

}
