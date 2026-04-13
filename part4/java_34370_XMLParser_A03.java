import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34370_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<message>Reminder: Drink up water.</message>\n" +
                "</note>";
        
        parseXml(xml);
    }
    
    public static void parseXml(String xml) {
        // Step 1: Create a factory for the DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        // Step 2: Use the factory to create a new DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Step 3: Parse the XML file into a Document object
        Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        
        // Step 4: Perform security-sensitive operations related to injection
        // We'll just print the XML document to the console, which is not recommended in a real-world application
        System.out.println(document.toString());
    }
}