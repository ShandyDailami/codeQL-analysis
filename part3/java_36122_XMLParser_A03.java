import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_36122_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // use it to create a new document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // create a new document
            Document doc = builder.parse(new File("sample.xml"));
            
            // print the XML file
            System.out.println(doc.getDocumentElement().getTagName());
            
            // get all the 'item' nodes
            NodeList nodes = doc.getElementsByTagName("item");
            // iterate through each 'item' node
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // print the text node of each 'item' node
                System.out.println("item " + (i + 1) + ": " + node.getTextContent());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}