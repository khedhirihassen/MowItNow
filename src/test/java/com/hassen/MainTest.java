package com.hassen;

import com.hassen.Exceptions.ExceptionMowItNow;
import com.hassen.Exceptions.Messages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MainTest {

    public final String CHEMIN_FICHIER = "src/main/resources/";

    @Rule
    public ExpectedException exceptionAttendu = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void erreur_fichier_vide() throws ExceptionMowItNow {
        Main.main(new String[]{CHEMIN_FICHIER + "fichierVide.txt"});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void erreur_fichier_mal_formatter() throws ExceptionMowItNow {
        Main.main(new String[]{CHEMIN_FICHIER + "fichierMalFormatter.txt"});
    }

    @Test
    public void erreur_fichier_ko_instruction() throws ExceptionMowItNow {
        exceptionAttendu.expect(ExceptionMowItNow.class);
        exceptionAttendu.expectMessage(Messages.ERREUR_DONNEES_INCORRECTES);
        Main.main(new String[]{CHEMIN_FICHIER + "fichierKoInstruction.txt"});
    }

    @Test
    public void erreur_fichier_ko_orientation() throws ExceptionMowItNow {
        exceptionAttendu.expect(ExceptionMowItNow.class);
        exceptionAttendu.expectMessage(Messages.ERREUR_DONNEES_INCORRECTES);
        Main.main(new String[]{CHEMIN_FICHIER + "fichierKoOrientation.txt"});
    }

    @Test
    public void lancer_fichier_ok() throws ExceptionMowItNow {

        List<String> resultatAttendu = new ArrayList<>();
        resultatAttendu.add("1 3 N");
        resultatAttendu.add("5 1 E");
        Main.main(new String[]{CHEMIN_FICHIER + "fichierOK.txt"});

        assertNotNull(Main.resultats);

        assertEquals(Main.resultats,resultatAttendu);

    }


}
