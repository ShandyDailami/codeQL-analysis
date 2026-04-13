import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_09161_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc;
        try {
            doc = builder.parse(inputFile);

            // Print out the XML document elements
            printElements(doc);
        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    private static void printElements(Document doc) {
        doc.getDocumentElement().normalize();
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        System.out.print("Child Node: ");
        printElements(doc.getDocumentElement().getFirstChild());
    }
}