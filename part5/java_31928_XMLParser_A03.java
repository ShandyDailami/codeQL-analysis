import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_31928_XMLParser_A03 {
    public static void parseXML(String filePath) {
        File xmlFile = new File(filePath);
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.setFeature("http://xml.org/sax/features/validation", true);
            xmlReader.setFeature("http://xml.org/sax/features/validation", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameters", false);
            xmlReader.setFeature("http://xml.org/sax/features/rng-supported", true);
            xmlReader.setFeature("http://xml.org/sax/features/axis-enforce-prefixes", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
            xmlReader.setFeature("http://xml.org/sax/features/xml-version", true);
            xmlReader.setFeature("http://xml.org/sax/features/xml-version", false);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        xmlReader.setContentHandler(new XMLContentHandler());
        try {
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}