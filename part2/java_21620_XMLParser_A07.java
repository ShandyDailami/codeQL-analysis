import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_21620_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";

        secureParseXML(xmlFilePath);
    }

    private static void secureParseXML(String xmlFilePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(xmlFilePath));
            // Do something with the parsed document

        } catch (SAXException e) {
            System.out.println("Parsing failed: " + e.getMessage());
       
        } catch (IOException e) {
            System.out.println("File not found: " + xmlFilePath);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}