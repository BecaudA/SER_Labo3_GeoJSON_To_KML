/*
 * File        : ch.heigvd.ser.labo3.CoordinateTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of Coordinate class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {
    @Test
    public void shouldCreateCoordinateWithCorrectAxisValues() {
        Coordinate c = new Coordinate("1", "4");
        Assert.assertEquals("1", c.getX());
        Assert.assertEquals("4", c.getY());
    }
}
