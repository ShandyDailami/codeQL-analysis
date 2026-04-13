import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_36847_XMLParser_A01 {

    public void parseXML(String fileName) {
        File xmlFile = new File(fileName);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new handler for XML parsing.
            XMLParserHandler handler = new XMLParserHandler();

            // Set the handler for the XMLReader.
            reader.setContentHandler(handler);

            // Parse the XML file.
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "/path/to/your/xml/file.xml";
        XMLParser parser = new XMLParser();
        parser.parseXML(xmlFilePath);
    }
}