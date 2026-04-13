import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_21856_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document doc = null;

        try {
            doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Document loaded. Validation succeeded.");
        } catch (SAXException e) {
            System.out.println("Validation failed. SAXException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read file. IOException: " + e.getMessage());
        }
    }
}