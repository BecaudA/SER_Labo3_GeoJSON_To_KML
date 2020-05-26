/*
 * File        : ch.heigvd.ser.labo3.Coordinate.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class represents a Coordinate in x and y axis stocked in String.
 */

package ch.heigvd.ser.labo3;

import java.util.Objects;

public class Coordinate{

    private final String X;
    private final String Y;

    /**
     * Constructor of ch.heigvd.ser.labo3.Coordinate.
     * @param x Point in x-axis.
     * @param y Point in y-axis.
     */
    public Coordinate(String x, String y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * Getter of X coordinate.
     * @return X attribute (instance of Double).
     */
    public String getX() {
        return X;
    }

    /**
     * Getter of Y coordinate.
     * @return Y attribute (instance of Double).
     */
    public String getY() {
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
