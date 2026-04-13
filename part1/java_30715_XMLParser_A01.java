import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_30715_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/sample.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (ParserConfigurationException e) {
            System.out.println("Failed to create XMLReader: " + e.getMessage());
            return;
        }

        xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
        xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        xmlReader.setFeature("http://xml.org/sax/features/validation", false);
        xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
        xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        xmlReader.setContentHandler(new XmlContentHandler());

        try {
            xmlReader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }
    }
}