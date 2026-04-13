import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_31220_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file into a DOM tree
            Document doc = builder.parse(new File("input.xml"));

            // Normalize the DOM tree to ensure trees are read in the same way
            doc.getDomConfig().setNormalizeWhitespace(true);

            // Print out each element and its content
            printElements(doc.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Element element) {
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Content: " + element.getTextContent());

        // Recursively print all elements and their contents
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElements((Element) element.getChildNodes().item(i));
        }
    }
}