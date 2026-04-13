import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_15568_XMLParser_A01 {

    public static void main(String[] args) {

        // Parse the XML file
        DOMParser parser = new DOMParser();
        try {
            parser.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the document
        Document document = parser.getDocument();

        // Get all element nodes
        NodeList nodeList = document.getElementsByTagName("*");

        // Loop over all nodes
        for (int i = 0; i < nodeList.getLength(); i++) {
            // Get the current node
            org.w3c.dom.Node node = nodeList.item(i);

            // Print the node name and value
            System.out.println("Node Name: " + node.getNodeName());
            System.out.println("Node Value: " + node.getTextContent());
        }
    }
}