package com.hassen.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PelouseTest {

    @Test
    public void verifier_egalite_pelouse(){

        Pelouse pelouse = new Pelouse(new Coordonnees(2,2));
        Pelouse pelouseOk = new Pelouse(new Coordonnees(2,2));
        Pelouse pelouseKo = new Pelouse(new Coordonnees(3,3));

        assertTrue(pelouseOk.equals(pelouse));
        assertFalse(pelouseOk.equals(pelouseKo));

    }

}
