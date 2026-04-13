import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_20309_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document document = builder.parse(new File("sample.xml"));

            // Get all elements in the document
            NodeList list = document.getElementsByTagName("sampleElement");

            // Iterate over all elements
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);

                // Print out the content of the element
                System.out.println("Content: " + element.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}