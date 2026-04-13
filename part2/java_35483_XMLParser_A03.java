import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35483_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Create a new Document
            Document doc = builder.newDocument();
            
            // Load the XML file
            InputStream inputStream = new FileInputStream("input.xml");
            doc.load(inputStream);
            
            // Here, we're not doing anything special to secure the input stream,
            // because we're not actually processing the XML. The purpose of this is
            // to demonstrate how XML parsers can be used in a legacy style.
            // If you were processing the XML, you would use something like
            // XPath queries or SAX (Simple API for XML) events to prevent injection attacks.
            
            System.out.println("XML file loaded successfully.");
        } catch (AccessControlException | ParserConfigurationException | SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}