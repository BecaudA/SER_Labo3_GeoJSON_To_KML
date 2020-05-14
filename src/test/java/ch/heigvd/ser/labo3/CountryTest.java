/*
 * File        : ch.heigvd.ser.labo3.CoordinateTest.java
  * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of ch.heigvd.ser.labo3.Coordinate class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountryTest {
    @Test
    public void shouldCreateCountryWithExpectedValues() {
        Polygon p1 = new Polygon();
        Polygon p2 = new Polygon();

        p1.addCoordinate(new Coordinate(5d, 2d));
        p1.addCoordinate(new Coordinate(-8d, 0d));
        p1.addCoordinate(new Coordinate(10d, -3d));

        p2.addCoordinate(new Coordinate(6d, 9d));
        p2.addCoordinate(new Coordinate(80d, -4d));
        p2.addCoordinate(new Coordinate(-4d, 54d));

        List<Polygon> polygons = new ArrayList<>();
        polygons.add(p1);
        polygons.add(p2);

        Country c = new Country("France", "FRA", polygons);

        Assert.assertEquals("France", c.getADMIN());
        Assert.assertEquals("FRA", c.getISO_A3());
        Assert.assertEquals(polygons, c.getBorders());
    }
}
