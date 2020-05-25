package ch.heigvd.ser.labo3;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.FileWriter;

public class KMLWriter {

    private Element document =  new Element("Document");

    /**
     * Constructor of KMLWriter.
     * @param pathToFile path to destination file.
     */
    public KMLWriter(String pathToFile, List<Country> list) {
        try {

            Element kml = new Element("kml");
            kml.setAttribute("xmlns2","http://www.opengis.net/kml/2.2");
            addContent(list);

            kml.addContent(document);

            // Writing in the destination file
            Document documentType = new Document(kml);
            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(documentType, new FileWriter(pathToFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add content from a list of FormattableToKML.
     * @param list list of FormattableToKML.
     */
    public void addContent(List<? extends FormattableToKML> list) {
        for (FormattableToKML obj: list) {
            document.addContent(obj.toKML());
        }
    }
}
