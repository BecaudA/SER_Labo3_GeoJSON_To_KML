/*
 * File        : ch.heigvd.ser.labo3.CoordinateTest.java
  * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of Country class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryTest {
    @Test
    public void shouldCreateCountryWithExpectedValues() {
        Polygon p1 = new Polygon();
        Polygon p2 = new Polygon();

        p1.addCoordinate(new Coordinate("5", "2"));
        p1.addCoordinate(new Coordinate("-8", "0"));
        p1.addCoordinate(new Coordinate("10", "-3"));

        p2.addCoordinate(new Coordinate("6", "9"));
        p2.addCoordinate(new Coordinate("80", "-4"));
        p2.addCoordinate(new Coordinate("-4", "54"));

        List<Polygon> polygons = new ArrayList<>();
        polygons.add(p1);
        polygons.add(p2);

        Country c = new Country("France", "FRA", polygons);

        Assert.assertEquals("France", c.getADMIN());
        Assert.assertEquals("FRA", c.getISO_A3());
        Assert.assertEquals(polygons, c.getBorders());
    }
}
