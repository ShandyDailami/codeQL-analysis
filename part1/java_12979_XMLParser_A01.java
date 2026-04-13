import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12979_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print the parsed document
            System.out.println("Document has been parsed.");
        } catch (IOException e) {
            System.out.println("Failed to parse the document.");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Failed to parse the document.");
            e.printStackTrace();
        }
    }
}