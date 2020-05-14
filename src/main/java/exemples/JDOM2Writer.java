package exemples;// inspiré de
//https://examples.javacodegeeks.com/core-java/xml/jdom/create-xml-file-in-java-using-jdom-parser-example/

import java.io.*;
import org.jdom2.*;
import org.jdom2.output.*;

public class JDOM2Writer {

    private static final String xmlFilePath = "src/newXMLfile.xml";

    public static void main(String[] args) {

        try {

            Element menus = new Element("menus");
            Document document = new Document(menus);

            Element menuFichier = new Element("menu");
            menuFichier.setAttribute(new Attribute("position", "1"));
            menuFichier.addContent(new Element("nom").setText("Fichier"));
            menuFichier.addContent(new Element("option").setText("Nouveau"));
            menuFichier.addContent(new Element("option").setText("Sauver"));
            menuFichier.addContent(new Element("option").setText("Quitter"));
            document.getRootElement().addContent(menuFichier);

            Element menuEdition = new Element("menu");
            menuEdition.setAttribute(new Attribute("position", "2"));
            menuEdition.addContent(new Element("nom").setText("Edition"));
            menuEdition.addContent(new Element("option").setText("Copier"));
            menuEdition.addContent(new Element("option").setText("Coller"));
            document.getRootElement().addContent(menuEdition);

//            Format format = Format.getPrettyFormat();
//            format.setIndent("   ");
//            XMLOutputter xmlOutputer = new XMLOutputter(format);
            
            XMLOutputter xmlOutputer = new XMLOutputter();
            xmlOutputer.setFormat(Format.getPrettyFormat());
            xmlOutputer.output(document, new FileWriter(xmlFilePath));

            System.out.println("XML File was created successfully!");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
