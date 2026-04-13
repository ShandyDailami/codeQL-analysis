import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_28730_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and store it in a Document object
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Print out the element name and text inside it
            System.out.println("Root element: " + root.getNodeName());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}