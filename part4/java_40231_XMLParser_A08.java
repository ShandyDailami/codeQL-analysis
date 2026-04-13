import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_40231_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Creating a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Creating a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Creating an XML file
            File file = new File("sample.xml");

            // Parsing the file
            Document doc = builder.parse(file);

            // Get all elements
            NodeList nodeList = doc.getElementsByTagName("*");

            // Loop through all elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get each node
                org.w3c.dom.Node node = nodeList.item(i);

                // Printing tag and content
                System.out.println("Tag: " + node.getNodeName());
                System.out.println("Content: " + node.getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}