package com.hassen.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordonnees {

    private int x;

    private int y;

    public boolean isHorsCoordonnesMax(Coordonnees coordonnees){
        return coordonnees.getX() >= 0
                && coordonnees.getY() >= 0
                && coordonnees.getX() <= this.x
                && coordonnees.getY() <= this.y;

    }

}
