/*
 * File        : ch.heigvd.ser.labo3.GeoJSONReaderTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Test class of GeoJSONReader class.
 */

package ch.heigvd.ser.labo3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeoJSONReaderTest {

    private static final String CONTENT = "{\n" +
            "\"type\": \"FeatureCollection\",\n" +
            "\"features\": [\n" +
            "{ \"type\": \"Feature\", \"properties\": { \"ADMIN\": \"Country1\", \"ISO_A3\": \"CT1\" }, \"geometry\": { \"type\": \"ch.heigvd.ser.labo3.Polygon\", \"coordinates\": [ [ [ -69.996937628999916, 12.577582098000036 ], [ -69.936390753999945, 12.531724351000051 ], [ -69.924672003999945, 12.519232489000046 ] ] ] } },\n" +
            "{ \"type\": \"Feature\", \"properties\": { \"ADMIN\": \"Country2\", \"ISO_A3\": \"CT2\" }, \"geometry\": { \"type\": \"ch.heigvd.ser.labo3.Polygon\", \"coordinates\": [ [ [ 71.049802287000091, 38.408664450000089 ], [ 71.057140340000046, 38.409026184000084 ], [ 71.064943482000103, 38.411816712000046 ] ], [ [ 71.076984091000043, 38.412178447000144 ], [ 71.049802287000091, 38.408664450000089 ], [ 71.049802287000094, 38.408664450000083 ] ] ] } }\n" +
            "]\n" +
            "}\n";

    private File tempGeoJSONFile;

    @Before
    public void generateTempGeoJSONFile() {
        // Try to create and write and example of GeoJSON into a temporary file
        try {
            tempGeoJSONFile = File.createTempFile("tmpCountries", ".geojson");
            tempGeoJSONFile.deleteOnExit();
            FileWriter fw = new FileWriter(tempGeoJSONFile.getAbsolutePath());
            fw.write(CONTENT);
            fw.flush();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void shouldGenerateProperListOfCountry() {

        // Prepare expected result
        List<Country> expected = new ArrayList<>();

        Polygon p1 = new Polygon();
        Polygon p2 = new Polygon();
        Polygon p3 = new Polygon();

        List<Polygon> lst1 = new ArrayList<>();
        List<Polygon> lst2 = new ArrayList<>();

        // p1 : [ -69.996937628999916, 12.577582098000036 ], [ -69.936390753999945, 12.531724351000051 ], [ -69.924672003999945, 12.519232489000046 ]
        p1.addCoordinate(new Coordinate("-69.996937628999916", "12.577582098000036"));
        p1.addCoordinate(new Coordinate("-69.936390753999945", "12.531724351000051"));
        p1.addCoordinate(new Coordinate("-69.924672003999945", "12.519232489000046"));

        // p2 : [ 71.049802287000091, 38.408664450000089 ], [ 71.057140340000046, 38.409026184000084 ], [ 71.064943482000103, 38.411816712000046 ]
        p2.addCoordinate(new Coordinate("71.049802287000091", "38.408664450000089"));
        p2.addCoordinate(new Coordinate("71.057140340000046", "38.409026184000084"));
        p2.addCoordinate(new Coordinate("71.064943482000103", "38.411816712000046"));

        // p3 : [ 71.076984091000043, 38.412178447000144 ], [ 71.049802287000091, 38.408664450000089 ], [ 71.049802287000094, 38.408664450000083 ]
        p3.addCoordinate(new Coordinate("71.076984091000043", "38.412178447000144"));
        p3.addCoordinate(new Coordinate("71.049802287000091", "38.408664450000089"));
        p3.addCoordinate(new Coordinate("71.049802287000094", "38.408664450000083"));

        lst1.add(p1);
        lst2.add(p2);
        lst2.add(p3);

        expected.add(new Country("Country1", "CT1",  lst1));
        expected.add(new Country("Country2", "CT2",  lst2));

        // Parse temp file
        GeoJSONReader gjr = new GeoJSONReader(tempGeoJSONFile.getAbsolutePath());
        List<Country> result = gjr.parse();

        // Compare results
        assertEquals(expected.size(), result.size());
    }

    @After
    public void deleteTempGeoJSONFile() throws IOException {
        if (tempGeoJSONFile.exists() && !tempGeoJSONFile.delete()) {
            throw new IOException("Temp file (" + tempGeoJSONFile.getAbsolutePath() + ") could not be deleted");
        }
    }
}
