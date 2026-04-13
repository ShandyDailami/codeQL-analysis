import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_09009_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseFile(xmlFile);
    }

    public static void parseFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("XML File successfully parsed");
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}