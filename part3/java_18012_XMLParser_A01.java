import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18012_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/sample.xml";
        parseFile(xmlFile);
    }

    public static void parseFile(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            // Here you can do any security-sensitive operations related to A01_BrokenAccessControl

            System.out.println("File parsed successfully");

        } catch (SAXException e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}