/*
 * File        : ch.heigvd.ser.labo3.GeoJSONReader.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class provide a parsing method of GeoJSON file toward a list of country.
 */

package ch.heigvd.ser.labo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class GeoJSONReader {

    private static final String FEATURES    = "features";
    private static final String PROPERTIES  = "properties";
    private static final String ADMIN       = "ADMIN";
    private static final String ISO_A3      = "ISO_A3";
    private static final String GEOMETRY    = "geometry";
    private static final String COORDINATES = "coordinates";

    private FileReader reader;

    /**
     * Constructor of ch.heigvd.ser.labo3.GeoJSONReader.
     * @param pathToFile Path to the file to parse later.
     */
    public GeoJSONReader(String pathToFile) {
        try {
            this.reader = new FileReader(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse the file (given with the constructor) and return a list of country.
     * @return an instance of list of country if success (return null if an error occurred).
     */
    public List<Country> parse() {

        // Check that the reader is instancied for parsing
        if (reader == null) {
            return null;
        }

        JSONParser jsonParser   = new JSONParser();
        List<Country> countries = new ArrayList<>();
        JSONObject jsonFeature;

        try {
            // Get features of GeoJSON collection
            JSONArray features = (JSONArray) ((JSONObject) jsonParser.parse(reader)).get(FEATURES);

            // Loop through all features to create ch.heigvd.ser.labo3.Country instance
            for (Object feature : features) {
                jsonFeature = (JSONObject) feature;
                countries.add(new Country(getADMIN(jsonFeature),
                                          getISO_A3(jsonFeature),
                                          getListPolygon(jsonFeature)));
            }

            // Close reader
            reader.close();
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * Get ADMIN field value from a 'feature' JSONObject.
     * @param obj 'feature' JSONObject.
     * @return ADMIN value (instance of String).
     * @throws ClassCastException if PROPERTIES or ADMIN field are not found from 'feature' JSONObject.
     * @throws NullPointerException if PROPERTIES or ADMIN field are not found from 'feature' JSONObject.
     */
    private String getADMIN(JSONObject obj) throws ClassCastException, NullPointerException {
        return (String) ((JSONObject) obj.get(PROPERTIES)).get(ADMIN);
    }

    /**
     * Get ISO_A3 field value from a 'feature' JSONObject.
     * @param obj 'feature' JSONObject.
     * @return ISO_A3 value (instance of String).
     * @throws ClassCastException if PROPERTIES or ISO_A3 field are not found from 'feature' JSONObject.
     * @throws NullPointerException if PROPERTIES or ISO_A3 field are not found from 'feature' JSONObject.
     */
    private String getISO_A3(JSONObject obj) {
        return (String) ((JSONObject) obj.get(PROPERTIES)).get(ISO_A3);
    }

    /**
     * Get a list of Polygons from a 'feature' JSONObject.
     * @param obj 'feature' JSONObject.
     * @return List of Polygons.
     * @throws ClassCastException if GEOMETRY or COORDINATES field are not found from 'feature' JSONObject.
     * @throws NullPointerException if GEOMETRY or COORDINATES field are not found from 'feature' JSONObject.
     * @throws IndexOutOfBoundsException if parser try to access an improperly set coordinate pair from 'feature' JSONObject.
     */
    private List<Polygon> getListPolygon(JSONObject obj) throws ClassCastException, NullPointerException, IndexOutOfBoundsException {

        List<Polygon> polygons = new ArrayList<>();
        Polygon polygon;
        JSONArray jsonCoordinate;

        // Get the coordinates from JSON object
        JSONArray coordinatesLists = (JSONArray) ((JSONObject) obj.get(GEOMETRY)).get(COORDINATES);

        // Loop through all coordinates lists to create lists of polygons
        for (Object coordinatesList : coordinatesLists) {

            // Create new empty ch.heigvd.ser.labo3.Polygon
            polygon = new Polygon();


            ////// A MODIFIER
            // Loop through all coordinates within current list to add new coordinate inside the polygon
            for (Object coordinate : (JSONArray) coordinatesList) {
                jsonCoordinate = (JSONArray) coordinate;
                if(jsonCoordinate.size() == 2) {
                    String coordX = jsonCoordinate.get(0).toString();
                    String coordY = jsonCoordinate.get(1).toString();
                    polygon.addCoordinate(new Coordinate(new Double(coordX), new Double(coordY)));
                }
                else{
                    // Pour les multigeometry (plusieurs polygones) JSONArray dans JSONArray ---> à modifier
                    for (Object multiCoord: (JSONArray) jsonCoordinate) {
                        JSONArray jsonCoordinate2 = (JSONArray) multiCoord;
                        String coordX = jsonCoordinate2.get(0).toString();
                        String coordY = jsonCoordinate2.get(1).toString();
                        polygon.addCoordinate(new Coordinate(new Double(coordX), new Double(coordY)));
                    }


                }
            }

            // Add the polygon to current polygons list
            polygons.add(polygon);
        }

        return polygons;
    }
}
