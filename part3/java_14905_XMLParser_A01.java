import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14905_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new DefaultHandler());
            File xmlFile = new File("example.xml");

            // Use the XMLReader class for memory efficiency
            XMLReader reader = parser.getXMLReader();

            // Set the error handler
            reader.setErrorHandler(new MyErrorHandler());

            // Parse the XML file
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implement the error handler
    static class MyErrorHandler implements XMLErrorHandler {
        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }
}