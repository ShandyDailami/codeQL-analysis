import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class java_02235_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Load the XML file
        InputStream is = XMLParserExample.class.getResourceAsStream("/example.xml");

        // Create a SAX parser
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(new DefaultHandler());

        // Parse the XML
        sp.parse(is, new XMLErrorHandler() {
            public void warning(SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }

            public void error(SAXParseException e) {
                System.out.println("Error: " + e.getMessage());
            }

            public void fatalError(SAXParseException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }
        });
    }

}