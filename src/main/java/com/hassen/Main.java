package com.hassen;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.Exceptions.Messages;
import com.hassen.models.*;
import com.hassen.services.TondeuseService;
import com.hassen.services.UtilService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static List<String> resultats;

    public static void main(String[] args) throws ExceptionMowItNow {

        if (args.length == 1) {
            resultats = lancerTondeuse(args[0]);
        } else {
            throw new IllegalArgumentException();
        }

    }

    /**
     * Fonction permet de lancer le fonctionnement de la tondeuse
     * @param filePath
     * @return
     * @throws ExceptionMowItNow
     */
    public static List<String> lancerTondeuse(String filePath) throws ExceptionMowItNow {

        List<String> allfileline = new ArrayList<>();
        List<String> nouvellesPositions = new ArrayList<>();
        try {
            Files.lines(Paths.get(filePath)).map(allfileline::add).collect(Collectors.toList());
            Pelouse pelouse = UtilService.getlimitePelouse(allfileline.get(0));

            for (int i = 1; i < allfileline.size(); i += 2) {

                PositionTondeuse positionTondeuse = UtilService.getPositionTondeuse(allfileline.get(i));
                List<Instruction> instructionList = UtilService.getInstructionsList(allfileline.get(i + 1));
                TondeuseService.executerInstructions(instructionList, pelouse, positionTondeuse);
                LOGGER.info(" Nouvelle position de tondeuse  " + UtilService.getPositionTondeuse(allfileline.get(i))
                        + " est " + positionTondeuse.toString());
                nouvellesPositions.add(positionTondeuse.toString());
            }

            LOGGER.info(" Taille de resultat " + nouvellesPositions.size());

            nouvellesPositions.stream().forEach(System.out::println);

            return nouvellesPositions;

        } catch (IOException ioe) {
           throw new ExceptionMowItNow(Messages.ERREUR_FICHIER_INEXISTANT);
        } catch (ExceptionMowItNow e) {
            throw new ExceptionMowItNow(Messages.ERREUR_DONNEES_INCORRECTES);
        }
    }

}