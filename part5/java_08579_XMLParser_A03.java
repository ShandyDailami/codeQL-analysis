import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;
import java.io.IOException;

public class java_08579_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use builder to parse the input file
            Document doc = builder.parse(new File("input.xml"));

            // Use doc to retrieve the value of the specific tag
            NodeList nList = doc.getElementsByTagName("tagName");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Value of tagName: " + nNode.getTextContent());
            }

            doc.detachNode(nList.item(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}