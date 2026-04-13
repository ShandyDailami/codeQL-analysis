import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_41509_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a factory for reading the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a new Document object
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Here you can perform operations on the document, like printing out all the elements

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}