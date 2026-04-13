import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02288_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // TODO: Security-sensitive operations related to A03_Injection
            // For example, directly reading the file content
            String fileContent = doc.getDocumentElement().getTextContent();

            // Another example, reading the XML tags
            doc.getDocumentElement().normalize();
            System.out.println("File content: " + fileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}