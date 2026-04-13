import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class java_41027_XMLParser_A01 {
    public void parseXML(String filename) {
        try {
            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Set up the parser
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filename));

            // Print out the XML contents
            printDocument(doc);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void printDocument(Document doc) {
        // Print out the root element of the document
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        // Print out all the element nodes
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            System.out.println("Element: " + node.getNodeName());
        }
    }
}