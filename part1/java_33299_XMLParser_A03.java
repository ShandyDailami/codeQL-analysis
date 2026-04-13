import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33299_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load XML file
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Start with 'java'
            System.out.println("java");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}