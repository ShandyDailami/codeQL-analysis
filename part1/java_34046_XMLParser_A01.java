import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_34046_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory instance.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Get the document builder from the factory.
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Step 3: Parse the XML document.
            Document doc = builder.parse(new File("example.xml"));
            
            // Step 4: Get the root element of the document.
            doc.getDocumentElement().normalize();
            
            // Step 5: Extract and print all 'item' nodes.
            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                System.out.println("Item " + (i + 1) + ": " + items.item(i).getTextContent());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}