/*
 * File        : ch.heigvd.ser.labo3.PolygonTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of ch.heigvd.ser.labo3.Polygon class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolygonTest {
     @Test
    public void shouldCreatePolygonWithExpectedCoordinates() {
         Polygon p = new Polygon();
         p.addCoordinate(new Coordinate(1d, -3d));
         p.addCoordinate(new Coordinate(-5d, 14d));
         p.addCoordinate(new Coordinate(0d, 0d));

         Assert.assertEquals((Double) 1d,    p.getCoordinate(0).getX());
         Assert.assertEquals((Double) (-3d), p.getCoordinate(0).getY());
         Assert.assertEquals((Double) (-5d), p.getCoordinate(1).getX());
         Assert.assertEquals((Double) 14d,   p.getCoordinate(1).getY());
         Assert.assertEquals((Double) 0d,    p.getCoordinate(2).getX());
         Assert.assertEquals((Double) 0d,   p.getCoordinate(2).getY());
     }
}
