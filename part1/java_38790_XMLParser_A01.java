import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38790_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            System.out.println("Document successfully parsed");
        } catch (Exception e) {
            System.out.println("Failed to parse the XML file");
            e.printStackTrace();
        }
    }
}