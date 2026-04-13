import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_20055_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // the path to your xml file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        File xml = new File(xmlFile);

        if (!xml.exists()) {
            System.out.println("The file " + xmlFile + " does not exist.");
            return;
        }

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new DefaultHandler());

            // add a listener to print out element names
            reader.setContentHandler(new ContentHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    System.out.println("Element: " + qName);
                }
            });

            reader.parse(new File(xmlFile));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}