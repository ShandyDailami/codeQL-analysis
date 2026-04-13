import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_37519_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();

            // create a new SAX handler and parse the XML file
            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(xmlFile);

            // print out the parsed data
            System.out.println("Processed data: " + saxHandler.getProcessedData());

        } catch (IOException e) {
            System.out.println("Error processing XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        }
    }
}