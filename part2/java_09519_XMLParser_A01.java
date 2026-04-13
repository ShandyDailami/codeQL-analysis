import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09519_XMLParser_A01 {

    private File xmlFile;

    public java_09519_XMLParser_A01(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public Document parseXML() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + xmlFile.getName());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error loading XML file: " + xmlFile.getName());
            e.printStackTrace();
        }

        return document;
    }

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file");
        SecureXMLParser parser = new SecureXMLParser(xmlFile);
        Document document = parser.parseXML();
        // further operations...
    }
}