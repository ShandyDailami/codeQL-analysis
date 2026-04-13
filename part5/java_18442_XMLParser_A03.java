import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_18442_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // create a new XMLParser
            XMLParserHandler handler = new XMLParserHandler();

            // add the handler to the reader
            reader.setContentHandler(handler);

            // parse the xml file
            reader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}