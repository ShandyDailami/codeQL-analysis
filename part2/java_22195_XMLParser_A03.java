import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import org.xml.sax.SAXException;

public class java_22195_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Step 4: Get the root element of the document
            Element root = document.getDocumentElement();

            // Step 5: Get all child nodes of the root element
            NodeList childNodes = root.getChildNodes();

            // Step 6: Process each child node
            for (int i = 0; i < childNodes.getLength(); i++) {
                Element child = (Element) childNodes.item(i);
                System.out.println("Child Node: " + child.getNodeName());
           .
            .
            // Handle more security-sensitive operations
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}