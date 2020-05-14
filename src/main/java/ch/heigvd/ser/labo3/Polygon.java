/*
 * File        : ch.heigvd.ser.labo3.Polygon.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class represents a polygon form in x and y axis.
 */

package ch.heigvd.ser.labo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polygon {
    List<Coordinate> points;

    public Polygon() {
        this.points = new ArrayList<>();
    }

    public void addCoordinate(Coordinate coordinate) {
        points.add(coordinate);
    }

    public Coordinate getCoordinate(int index) {
        if (index < 0) {
            return null;
        }
        return points.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return points.equals(polygon.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
