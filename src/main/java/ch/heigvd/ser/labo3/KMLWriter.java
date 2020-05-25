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

            // Add the list of object extending FormattableToKML to the document content
            document = new Element("Document");
            for (FormattableToKML obj : list) {
                document.addContent(obj.toKML());
            }

            kml.addContent(document);

            // Writing in the destination file
            xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(new Document(kml), new FileWriter(pathToFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
