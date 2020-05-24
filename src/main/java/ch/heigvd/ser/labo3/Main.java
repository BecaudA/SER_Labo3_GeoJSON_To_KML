/*
 * File        : ch.heigvd.ser.labo3.Main.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : ch.heigvd.ser.labo3.Main class using implemented classes to parse and convert the GeoJSON file to KML.
 */

package ch.heigvd.ser.labo3;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GeoJSONReader geoJSONreader = new GeoJSONReader("./src/main/java/ch/heigvd/ser/labo3/countries.geojson");
        KMLWriter kml = new KMLWriter("src/export.kml",geoJSONreader.parse());

    }
}
