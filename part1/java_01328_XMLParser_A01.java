import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01328_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/broken_access_controls.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Parse the XML document here, for example:
            System.out.println("Document title: " + document.getDocumentElement().getTagName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}