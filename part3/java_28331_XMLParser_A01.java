import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28331_XMLParser_A01 {

    public static void main(String[] args) {
        File file = new File("sensitiveData.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Here we parse the document and do some security-sensitive operations
            // For example, we are accessing the inner text of an element
            String sensitiveData = document.getElementsByTagName("sensitiveData").item(0).getTextContent();

            System.out.println("Sensitive data: " + sensitiveData);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}