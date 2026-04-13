import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_33145_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a new instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document document = builder.parse(new File("path/to/your/xml/file.xml"));

            // Extract the root element
            Element root = document.getDocumentElement();

            // Extract all the child nodes of the root
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                // Here, we're just printing the node name and content for demonstration
                System.out.println("Child node " + (i + 1) + ": " + childNodes.item(i).getNodeName());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}