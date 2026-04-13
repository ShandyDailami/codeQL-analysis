import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_40955_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false);
            xmlReader.setFeature("http://xml.org/sax/features/validation", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        XMLReaderHandler handler = new XMLReaderHandler();
        try {
            xmlReader.setContentHandler(handler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}