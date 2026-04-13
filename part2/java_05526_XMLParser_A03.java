import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_05526_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document doc = builder.parse(new File("example.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Get all the child nodes of the root element
            NodeList childNodes = root.getChildNodes();

            // Process each child node
            for (int i = 0; i < childNodes.getLength(); i++) {
                Element child = (Element) childNodes.item(i);
                System.out.println("Child Node: " + child.getNodeName());
                System.out.println("Child Node Value: " + child.getFirstChild().getNodeValue());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}