import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_28045_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 4: Get all the child nodes of the document
            NodeList nodes = doc.getElementsByTagName("*");

            // Step 5: Iterate over all the nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element: " + element.getTagName());
                System.out.println("Value: " + element.getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}