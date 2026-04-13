import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32052_XMLParser_A01 {
    public Document parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document doc;
        
        try {
            doc = builder.parse(fileName);
        } catch (SAXException e) {
            System.out.println("Failed to parse XML file: " + e.getMessage());
            return null;
        }
        
        return doc;
    }
}