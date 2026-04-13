import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_34162_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // create a new DOM parser
            DOMParser parser = new DOMParser();
            // load the XML file
            parser.parse(new File("example.xml"));
            // get the document
            Document doc = parser.getDocument();
            // get all the nodes in the document
            NodeList nodes = doc.getElementsByTagName("*");
            // iterate over all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                // print out the name and value of the node
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getNodeName() + " - " + nodes.item(i).getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}