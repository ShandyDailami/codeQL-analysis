import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_26894_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Load XML document
            Document doc = builder.parse(new File("test.xml"));

            // Security-sensitive operation
            // Try to access a file in the XML document
            File file = new File("test.txt");
            if (file.exists()) {
                System.out.println("Access Denied!");
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}