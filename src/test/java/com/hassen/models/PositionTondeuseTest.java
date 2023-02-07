package com.hassen.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTondeuseTest {

    @Test
    public void verifier_egalite_positionTondeuse(){

        PositionTondeuse positionTondeuse = new PositionTondeuse(new Coordonnees(5,5),Orientation.N);
        PositionTondeuse positionTondeuseOk = new PositionTondeuse(new Coordonnees(5,5),Orientation.N);
        PositionTondeuse positionTondeuseKo = new PositionTondeuse(new Coordonnees(5,5),Orientation.E);

        assertTrue(positionTondeuseOk.equals(positionTondeuse));
        assertFalse(positionTondeuseOk.equals(positionTondeuseKo));

    }

}
