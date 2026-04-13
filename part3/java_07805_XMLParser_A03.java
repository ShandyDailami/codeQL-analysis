import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_07805_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your XML file
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        File xml = new File(xmlFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);

            // process XML document here

        } catch (IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}