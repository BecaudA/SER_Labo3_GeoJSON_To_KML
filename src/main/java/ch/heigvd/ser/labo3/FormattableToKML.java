/*
 * File        : ch.heigvd.ser.labo3.FormattableToKML.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 14.05.2020
 * Description : This interface provides an Element (instance of org.jdom2.Element) in kml format.
 */

package ch.heigvd.ser.labo3;

import org.jdom2.Element;

public interface FormattableToKML {
    /**
     * Get an element corresponding to the instance of the caller.
     * @return instance of Element.
     */
    Element toKML();
}
