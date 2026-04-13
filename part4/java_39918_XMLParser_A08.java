import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_39918_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Get a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 2: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 3: Get all elements
            NodeList nodes = doc.getElementsByTagName("*");

            // Step 4: Print out the names of all the elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element name: " + element.getTagName());
            }

            // Step 5: Close the document
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}