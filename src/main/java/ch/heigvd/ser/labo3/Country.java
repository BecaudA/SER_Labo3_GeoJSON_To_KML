/*
 * File        : ch.heigvd.ser.labo3.Country.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This class represents a country with his ADMIN and ISO_A3 names.
 *               A country possesses a list of ch.heigvd.ser.labo3.Polygon to represent his borders.
 */

package ch.heigvd.ser.labo3;

import java.util.List;
import java.util.Objects;

public class Country {
    private final String ADMIN;
    private final String ISO_A3;
    private final List<Polygon> borders;

    /**
     * Constructor of ch.heigvd.ser.labo3.Country.
     * @param admin Full name of the country.
     * @param iso_a3 ISO A3 format of country name.
     * @param borders List of ch.heigvd.ser.labo3.Polygon representing the borders of the country.
     */
    public Country(String admin, String iso_a3, List<Polygon> borders) {
        this.ADMIN = admin;
        this.ISO_A3 = iso_a3;
        this.borders = borders;
    }

    /**
     * Getter of ADMIN country's name.
     * @return ADMIN attribute (instance of String).
     */
    public String getADMIN() {
        return ADMIN;
    }

    /**
     * Getter of ISO_A3 country's name.
     * @return ISO_A3 attribute (instance of String).
     */
    public String getISO_A3() {
        return ISO_A3;
    }

    /**
     * Getter of borders of the country.
     * @return borders attribute (instance of List of ch.heigvd.ser.labo3.Polygon).
     */
    public List<Polygon> getBorders() {
        return borders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return ADMIN.equals(country.ADMIN) &&
                ISO_A3.equals(country.ISO_A3) &&
                borders.equals(country.borders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ADMIN, ISO_A3, borders);
    }
}
