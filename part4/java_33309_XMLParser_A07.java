import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_33309_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFilePath = "authfailure.xml";

        try {
            parseXmlFile(xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(String xmlFilePath) throws IOException {
        File xmlFile = new File(xmlFilePath);

        // Create a new SAX Reader
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Create a new DefaultHandler
        DefaultHandler handler = new DefaultHandler();

        reader.setContentHandler(handler);

        // Parse the XML file
        reader.parse(xmlFile);
    }
}