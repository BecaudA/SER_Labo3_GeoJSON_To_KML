/*
 * File        : ch.heigvd.ser.labo3.PolygonTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of Polygon class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

public class PolygonTest {
     @Test
    public void shouldCreatePolygonWithExpectedCoordinates() {
         Polygon p = new Polygon();
         p.addCoordinate(new Coordinate("1", "-3"));
         p.addCoordinate(new Coordinate("-5", "14"));
         p.addCoordinate(new Coordinate("0", "0"));

         Assert.assertEquals("1",  p.getCoordinate(0).getX());
         Assert.assertEquals("-3", p.getCoordinate(0).getY());
         Assert.assertEquals("-5", p.getCoordinate(1).getX());
         Assert.assertEquals("14", p.getCoordinate(1).getY());
         Assert.assertEquals("0",  p.getCoordinate(2).getX());
         Assert.assertEquals("0",  p.getCoordinate(2).getY());
     }
}
