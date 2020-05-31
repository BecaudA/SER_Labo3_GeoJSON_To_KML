/*
 * File        : ch.heigvd.ser.labo3.Main.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Main class using implemented classes to parse and convert the GeoJSON file to KML.
 */

package ch.heigvd.ser.labo3;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final String  SRC_GEOJSON = "./data/countries.geojson";
        final String  DST_KML     = "./data/countries.kml";
        List<Country> countries;

        // Parse GeoJSON file
        GeoJSONReader geoJSONreader = new GeoJSONReader(SRC_GEOJSON);
        countries = geoJSONreader.parse();

        // Print countries
        for (Country country : countries) {
            System.out.println('(' + country.getISO_A3() + ") " + country.getADMIN());
            for (Polygon border : country.getBorders()) {
                System.out.println("      - " + border.amountOfCoordinates() + " coordinates");
            }
        }

        // Write KML file
        KMLWriter kml = new KMLWriter(DST_KML, countries);
        kml.write();

    }
}
