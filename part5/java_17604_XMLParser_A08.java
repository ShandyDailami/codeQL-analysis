import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXParseException;

public class java_17604_XMLParser_A08 {

    public Document parse(String fileName) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));
        return document;
    }

    public void handleError(SAXParseException e) {
        System.out.println("XML Parsing Error: " + e.getMessage());
    }

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            Document document = parser.parse("input.xml");
            // your code here
        } catch (IOException | SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
       
        }
    }
}