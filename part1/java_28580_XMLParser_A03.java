import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28580_XMLParser_A03 {

    public void parse(String filePath) {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Perform security-sensitive operations related to A03_Injection here
        // For instance, we're just printing the document root element
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
    }
}