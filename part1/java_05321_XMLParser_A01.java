import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_05321_XMLParser_A01 {

    public static void main(String[] args) {

        // Create a SAX parser factory
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // Create a SAX parser using the factory
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // Create a SAX reader
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();

        // Set the ContentHandler to the SAX reader
        xmlReader.setContentHandler(new ContentHandlerImpl());

        // Parse the XML file
        try {
            saxParser.parse(new File("input.xml"), xmlReader);
        } catch (SAXException | SAXParseException e) {
            e.printStackTrace();
        }
    }
}