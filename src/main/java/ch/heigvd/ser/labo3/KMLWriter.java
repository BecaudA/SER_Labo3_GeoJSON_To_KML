/*
 * File        : ch.heigvd.ser.labo3.KMLWriter.java
 * Authors     : Arthur Bécaud & Nenad Rajic
 * Created on  : 20.05.2020
 * Description : This class provide a writing method of <? extends FormattableToKML> object in a kml format.
 */
package ch.heigvd.ser.labo3;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.FileWriter;

public class KMLWriter {

    private final String pathToFile;
    private final List<? extends FormattableToKML> list;

    /**
     * Constructor of KMLWriter.
     * @param pathToFile Path to destination file.
     * @param list List of object to add to kml file.
     */
    public KMLWriter(String pathToFile, List<? extends FormattableToKML> list) {
        this.pathToFile = pathToFile;
        this.list       = list;
    }

    public void write() {
        Element kml;
        Element document;
        XMLOutputter xmlOutputer;

        try {
            // Create kml main element and set his attribute
            kml = new Element("kml");
            kml.setAttribute("xmlns2","http://www.opengis.net/kml/2.2");

            // Document Element
            document = new Element("Document");

            // Set Polygon Style in Document Element
            document.addContent(getPolygonStyleElement());

            // Add the list of object extending FormattableToKML to the document content
            for (FormattableToKML obj : list) {
                document.addContent(obj.toKML());
            }

            kml.addContent(document);

            // Writing in the destination file
            FileWriter fw = new FileWriter(pathToFile);
            xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(new Document(kml), fw);

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a Style Element for Polygon with a specific id set to "polygonStyle".
     * @return Style Element.
     */
    protected Element getPolygonStyleElement() {
        Element style     = new Element("Style").setAttribute("id", "polygonStyle");
        Element polyStyle = new Element("PolyStyle");

        polyStyle.addContent(new Element("color").addContent("ffffffff"));
        polyStyle.addContent(new Element("colorMode").addContent("normal"));
        polyStyle.addContent(new Element("fill").addContent("0"));
        polyStyle.addContent(new Element("outline").addContent("1"));

        style.addContent(polyStyle);

        return style;
    }
}
