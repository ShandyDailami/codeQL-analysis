import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_33338_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            Document doc = builder.parse(new File("input.xml"));
            
            // Print out the XML contents
            printDocument(doc);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Print out the XML file
        System.out.println(doc.getDocumentElement().getTagName());
    }
}