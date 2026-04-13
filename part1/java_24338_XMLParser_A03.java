import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import java.io.FileReader;
import java.io.IOException;

public class java_24338_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("example.xml"));
            
            // Step 4: Extract the required nodes and attributes
            NodeList nodes = doc.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element nodeElement = (Element) nodes.item(i);
                
                // Security-sensitive operations related to injection
                String attributeValue = nodeElement.getAttribute("attribute");
                System.out.println("Attribute value: " + attributeValue);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}