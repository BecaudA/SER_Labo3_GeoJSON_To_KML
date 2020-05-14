/*
 * File        : ch.heigvd.ser.labo3.Coordinate.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class represents a ch.heigvd.ser.labo3.Coordinate in x and y axis.
 */

package ch.heigvd.ser.labo3;

import java.util.Objects;

public class Coordinate {
    private final Double X;
    private final Double Y;



    /**
     * Constructor of ch.heigvd.ser.labo3.Coordinate.
     * @param x Point in x-axis.
     * @param y Point in y-axis.
     */
    public Coordinate(Double x, Double y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * Getter of X coordinate.
     * @return X attribute (instance of Double).
     */
    public Double getX() {
        return X;
    }

    /**
     * Getter of Y coordinate.
     * @return Y attribute (instance of Double).
     */
    public Double getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return X.equals(that.X) &&
                Y.equals(that.Y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
