/*
 * File        : ch.heigvd.ser.labo3.KMLWriterTest.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 26.05.2020
 * Description : Test class of KMLWriter class.
 */
package ch.heigvd.ser.labo3;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMLWriterTest {
    private static final String EXPECTED_OUTPUT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<kml xmlns2=\"http://www.opengis.net/kml/2.2\">\n" +
            "  <Document>\n" +
            "    <Style id=\"polygonStyle\">\n" +
            "      <PolyStyle>\n" +
            "        <color>ffffffff</color>\n" +
            "        <colorMode>normal</colorMode>\n" +
            "        <fill>0</fill>\n" +
            "        <outline>1</outline>\n" +
            "      </PolyStyle>\n" +
            "    </Style>\n" +
            "    <Placemark>\n" +
            "      <name>Country1</name>\n" +
            "      <styleUrl>#polygonStyle</styleUrl>\n" +
            "      <ExtendedData>\n" +
            "        <SchemaData>\n" +
            "          <SimpleData name=\"ADMIN\">Country1</SimpleData>\n" +
            "          <SimpleData name=\"ISO_A3\">CT1</SimpleData>\n" +
            "        </SchemaData>\n" +
            "      </ExtendedData>\n" +
            "      <Polygon>\n" +
            "        <outerBoundaryIs>\n" +
            "          <LinearRing>\n" +
            "            <coordinates>-69.996937628999916,12.577582098000036 -69.936390753999945,12.531724351000051 -69.924672003999945,12.519232489000046</coordinates>\n" +
            "          </LinearRing>\n" +
            "        </outerBoundaryIs>\n" +
            "      </Polygon>\n" +
            "    </Placemark>\n" +
            "    <Placemark>\n" +
            "      <name>Country2</name>\n" +
            "      <styleUrl>#polygonStyle</styleUrl>\n" +
            "      <ExtendedData>\n" +
            "        <SchemaData>\n" +
            "          <SimpleData name=\"ADMIN\">Country2</SimpleData>\n" +
            "          <SimpleData name=\"ISO_A3\">CT2</SimpleData>\n" +
            "        </SchemaData>\n" +
            "      </ExtendedData>\n" +
            "      <MultiGeometry>\n" +
            "        <Polygon>\n" +
            "          <outerBoundaryIs>\n" +
            "            <LinearRing>\n" +
            "              <coordinates>71.049802287000091,38.408664450000089 71.057140340000046,38.409026184000084 71.064943482000103,38.411816712000046</coordinates>\n" +
            "            </LinearRing>\n" +
            "          </outerBoundaryIs>\n" +
            "        </Polygon>\n" +
            "        <Polygon>\n" +
            "          <outerBoundaryIs>\n" +
            "            <LinearRing>\n" +
            "              <coordinates>71.076984091000043,38.412178447000144 71.049802287000091,38.408664450000089 71.049802287000094,38.408664450000083</coordinates>\n" +
            "            </LinearRing>\n" +
            "          </outerBoundaryIs>\n" +
            "        </Polygon>\n" +
            "      </MultiGeometry>\n" +
            "    </Placemark>\n" +
            "  </Document>\n" +
            "</kml>\n";

    /**
     * Compare file content with Test EXPECTED_OUTPUT variable.
     * @param file File to compare.
     * @return True if the file content is the same as EXPECTED_OUTPUT content.
     * @throws FileNotFoundException if file is not found.
     */
    private boolean compareFileWithExpectedContent(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        String[] arr = EXPECTED_OUTPUT.split("\n");
        int line = 0;

        // Read file line by line with the scanner
        while (scanner.hasNextLine() && line < arr.length) {
            String data = scanner.nextLine();
            if (!data.equals(arr[line++])) {
                return false;
            }
        }

        // Save result in temporary variable to close Scanner before returning result
        boolean tmp = !scanner.hasNextLine() && line == arr.length;
        scanner.close();

        return tmp;
    }

    @Test
    public void shouldGenerateProperKMLFile() {

        File outputFile;

        // Prepare expected result
        List<Country> countries = new ArrayList<>();

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

        countries.add(new Country("Country1", "CT1",  lst1));
        countries.add(new Country("Country2", "CT2",  lst2));

        // Create a temporary file for KMLWriter to write into
        try {
            outputFile = File.createTempFile("outputCountries", ".kml");
            outputFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
            return;
        }

        // Write KML file
        KMLWriter writer = new KMLWriter(outputFile.getAbsolutePath(), countries);
        writer.write();

        // Verify if the output is correct
        try {
            Assert.assertTrue(compareFileWithExpectedContent(outputFile));
            // Try to delete outputFile
            if (outputFile.exists() && !outputFile.delete()) {
                throw new IOException("Temp file (" + outputFile.getAbsolutePath() + ") could not be deleted");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
