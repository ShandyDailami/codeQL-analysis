import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_27877_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse("src/main/resources/sample.xml");

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // You can use the DOM API to manipulate the document.
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}