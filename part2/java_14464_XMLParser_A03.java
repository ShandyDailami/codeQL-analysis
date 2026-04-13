import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_14464_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Parse the xml file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements of the xml
            NodeList nodes = doc.getElementsByTagName("*");

            // Print all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getNodeName());
            }

            // Close the xml file
            doc.detach();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}