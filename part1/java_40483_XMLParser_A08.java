import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

public class java_40483_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            System.out.println("XML Parsing Successful");

            // For testing
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}