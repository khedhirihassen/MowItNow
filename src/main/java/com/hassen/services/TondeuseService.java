package com.hassen.services;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.models.Instruction;
import com.hassen.models.Pelouse;
import com.hassen.models.PositionTondeuse;

import java.util.List;

public class TondeuseService {

    /**
     * Fonction permet d'executer une liste des instructions
     * @param instructions
     * @param pelouse
     * @param positionTondeuse
     * @throws ExceptionMowItNow
     */
    public static void executerInstructions(List<Instruction> instructions , Pelouse pelouse, PositionTondeuse positionTondeuse) throws ExceptionMowItNow {

        for (Instruction instruction : instructions) {
            InstructionService.executerInstruction(positionTondeuse,pelouse.getCoordonneesMax(), instruction);
        }
    }



}
