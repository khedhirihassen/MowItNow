package com.hassen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionTondeuse {

    private Coordonnees coordonnees;

    private Orientation orientation;

    public String toString() {
        return getCoordonnees().getX()
                + " "
                + getCoordonnees().getY()
                + " "
                + getOrientation();
    }

}
