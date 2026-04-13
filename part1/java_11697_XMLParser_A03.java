import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_11697_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new instance of DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder for the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input XML file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element of the document
            Element rootElement = doc.getDocumentElement();

            // Get all the child nodes of the root element
            NodeList childNodes = rootElement.getChildNodes();

            // Write the child nodes to a file
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < childNodes.getLength(); i++) {
                writer.write(childNodes.item(i).getNodeName() + "\n");
            }
            writer.close();

            System.out.println("Successfully parsed and wrote the XML file!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}