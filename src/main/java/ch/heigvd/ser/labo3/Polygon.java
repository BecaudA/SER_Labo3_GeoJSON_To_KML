/*
 * File        : ch.heigvd.ser.labo3.Polygon.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class represents a polygon form in x and y axis.
 */

package ch.heigvd.ser.labo3;

import org.jdom2.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polygon implements FormattableToKML {

    List<Coordinate> points;

    /**
     * Constructor of Polygon.
     */
    public Polygon() {
        this.points = new ArrayList<>();
    }

    /**
     * Add a point to the list of points forming the polygon.
     * @param coordinate Coordinate to add.
     */
    public void addCoordinate(Coordinate coordinate) {
        points.add(coordinate);
    }

    /**
     * Get the Coordinate at given index.
     * @param index Index of the coordinate.
     * @return Instance of coordinate or null if index is out of range.
     * @apiNote This methods is mainly used in test class.
     */
    public Coordinate getCoordinate(int index) {
        if (index < 0) {
            return null;
        }
        return points.get(index);
    }

    /**
     * Return how many coordinates are used for the polygon.
     * @return the amount of coordinates.
     */
    public int amountOfCoordinates() {
        return points.size();
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

    @Override
    public Element toKML() {

        Element polygon         = new Element("Polygon");
        Element outerBoundaryIs = new Element("outerBoundaryIs");
        Element linearRing      = new Element("LinearRing");
        Element coord           = new Element("coordinates");

        for (Coordinate cor : points) {
            coord.addContent(cor.getX() + "," + cor.getY() + " ");
        }

        linearRing.addContent(coord);
        outerBoundaryIs.addContent(linearRing);
        polygon.addContent(outerBoundaryIs);

        return polygon;

    }
}
