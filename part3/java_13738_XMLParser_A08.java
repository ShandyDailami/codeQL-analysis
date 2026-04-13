import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_13738_XMLParser_A08 {
    public static void main(String[] args) {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Use the factory to create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML file
        Document doc = null;
        try {
            doc = builder.parse(new File("sample.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 4: Retrieve the node list
        NodeList nodeList = doc.getElementsByTagName("student");

        // Step 5: Traverse the node list
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            // Extract and print the details of the current student
            System.out.println("Student " + (i + 1) + " details:");
            System.out.println("Name: " + node.getChildNodes().item(0).getNodeValue());
            System.out.println("Age: " + node.getChildNodes().item(1).getNodeValue());
            System.out.println("Grade: " + node.getChildNodes().item(2).getNodeValue());
            System.out.println("------------------------");
        }
    }
}