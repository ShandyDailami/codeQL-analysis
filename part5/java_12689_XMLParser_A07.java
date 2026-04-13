import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_12689_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document doc = builder.parse(new SourceResource("input.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Print the name of the root element
            System.out.println("Root element: " + root.getNodeName());

            // Get the first child of the root element
            Node firstChild = root.getFirstChild();

            // Print the name of the first child
            System.out.println("First child: " + firstChild.getNodeName());

            // Get the second child of the root element
            Node secondChild = root.getChildNodes().getItem(1);

            // Print the name of the second child
            System.out.println("Second child: " + secondChild.getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}