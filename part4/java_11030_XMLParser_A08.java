import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_11030_XMLParser_A08 {
    // Implementing the SAX (Simple API for XML) parser
    public void parseXML(String fileName) {
        try {
            // Create a new instance of DefaultHandler
            DefaultHandler handler = new DefaultHandler();

            // Create a new instance of XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set the content handler of the reader
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(fileName);

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}