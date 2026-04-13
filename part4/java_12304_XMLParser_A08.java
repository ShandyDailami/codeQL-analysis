import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.security.Init;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_12304_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML security library
            Init.init();
            
            // Create a new DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Parse the XML document
            Document doc = dBuilder.parse(new File("sample.xml"));
            
            // Retrieve all the nodes in the document
            NodeList nodeList = doc.getElementsByTagName("node");
            
            // Print all the nodes
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node #" + (i + 1) + ": " + nodeList.item(i).getTextContent());
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}