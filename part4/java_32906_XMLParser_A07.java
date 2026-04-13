import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class java_32906_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        parseXML(xmlFile);
    }

    private static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("SAXParseException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        }

        // Continue with your processing here
    }
}