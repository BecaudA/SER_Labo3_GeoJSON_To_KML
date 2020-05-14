/*
 * File        : ch.heigvd.ser.labo3.CoordinateTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of ch.heigvd.ser.labo3.Coordinate class.
 */

package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CoordinateTest {
    @Test
    public void shouldCreateCoordinateWithCorrectAxisValues() {
        Coordinate c = new Coordinate(1d, 4d);
        Assert.assertEquals((Double) 1d, c.getX());
        Assert.assertEquals((Double)  4d, c.getY());
    }
}
