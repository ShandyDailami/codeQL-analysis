import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_03552_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("yourfile.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();

            // Print all element names
            printElements(doc);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeName());
        }
    }
}