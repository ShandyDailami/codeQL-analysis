import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

public class java_01650_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Load the XML file
        File xmlFile = new File("sample.xml");
        XMLLoader loader = new XMLLoader(xmlFile);

        // Create a SAX parser
        XMLParser parser = loader.getParser();

        // Create a default handler
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }
        };

        // Parse the XML file
        parser.setContentHandler(handler);
        parser.parse();
    }

}