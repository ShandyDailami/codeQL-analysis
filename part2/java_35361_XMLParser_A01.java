import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_35361_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file and store it in a Document object
            Document document = builder.parse(new File("example.xml"));

            // Get a list of the child nodes of the document
            NodeList nodeList = document.getElementsByTagName("person");

            // Iterate over the list of child nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                // Get the i-th child node
                Node node = nodeList.item(i);
                System.out.println("Person " + (i + 1) + ": " + node.getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}