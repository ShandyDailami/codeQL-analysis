import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_14736_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new instance of XMLReader
            XMLReader reader = XMLReader.newInstance();

            // Create a new instance of File
            File inputFile = new File("input.xml");

            // Create a new instance of Document
            Document document = reader.read(inputFile);

            // Get the root element of the document
            Element root = document.getDocumentElement();

            // Print the tag name of the root element
            System.out.println("Root element: " + root.getNodeName());

            // Get the first child of the root element
            Node child = root.getFirstChild();

            // Print the tag name of the first child
            System.out.println("First child: " + child.getNodeName());

            // Get the second child of the root element
            child = root.getChildNodes().item(1);

            // Print the tag name of the second child
            System.out.println("Second child: " + child.getNodeName());
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}