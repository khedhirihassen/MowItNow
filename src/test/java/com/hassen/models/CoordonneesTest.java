package com.hassen.models;


import org.junit.Test;
import static org.junit.Assert.*;

public class CoordonneesTest {

    @Test
    public void verifier_egalite_coordonnees(){

        Coordonnees coordonnees = new Coordonnees(2,2);
        Coordonnees coordonneesOk = new Coordonnees(2,2);
        Coordonnees coordonneesKo = new Coordonnees(2,1);

        assertTrue(coordonneesOk.equals(coordonnees));
        assertFalse(coordonneesOk.equals(coordonneesKo));

    }

    @Test
    public void verifier_coordonnees(){

        Coordonnees coordonneesMax = new Coordonnees(5,5);

        Coordonnees coordonneesDansPelouse = new Coordonnees(1,2);
        Coordonnees coordonneesHorsPelouse = new Coordonnees(6,2);

        assertFalse(coordonneesMax.isHorsCoordonnesMax(coordonneesHorsPelouse));
        assertTrue(coordonneesMax.isHorsCoordonnesMax(coordonneesDansPelouse));

    }

}
