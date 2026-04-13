import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;

public class java_05481_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory that can build a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            InputStream in = XMLParser.class.getResourceAsStream("/example.xml");
            Document doc = builder.parse(in);

            // Do something with the document
            System.out.println("XML Parsing Successful");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}