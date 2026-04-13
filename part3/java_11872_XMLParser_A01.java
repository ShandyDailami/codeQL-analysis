import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11872_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DefaultHandler handler = new DefaultHandler();

        try {
            Document document = builder.parse(new File("sample.xml"));

            // Extract all 'item' nodes
            NodeList itemNodes = document.getElementsByTagName("item");

            // Iterate over each 'item' node
            for (int i = 0; i < itemNodes.getLength(); i++) {
                // Print the text content of the current node
                System.out.println("Item " + (i + 1) + ": " + itemNodes.item(i).getTextContent());
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}