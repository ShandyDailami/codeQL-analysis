import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17271_XMLParser_A01 {
    
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            
            // Here you would handle the XML document.
            // For the sake of example, we'll just print out the document.
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getElements().getItem(0).getNodeName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}