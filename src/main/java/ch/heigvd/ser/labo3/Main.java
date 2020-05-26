/*
 * File        : ch.heigvd.ser.labo3.Main.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : Main class using implemented classes to parse and convert the GeoJSON file to KML.
 */

package ch.heigvd.ser.labo3;

public class Main {
    public static void main(String[] args) {

        final String SRC_GEOJSON = "./data/countries.geojson";
        final String DST_KML     = "./data/countries.kml";

        GeoJSONReader geoJSONreader = new GeoJSONReader(SRC_GEOJSON);
        KMLWriter kml = new KMLWriter(DST_KML, geoJSONreader.parse());
        kml.write();

    }
}
