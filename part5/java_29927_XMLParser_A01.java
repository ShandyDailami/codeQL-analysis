import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_29927_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();

            // Use a custom handler to handle SAX events
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.setErrorHandler(new MyErrorHandler());

            // Start parsing the XML file
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}