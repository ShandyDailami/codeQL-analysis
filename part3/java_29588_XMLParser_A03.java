import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29588_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String xmlFile = "sample.xml";  // Assuming the XML file to be located in the same directory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Here you can perform security-sensitive operations related to A03_Injection
            // For instance, you can parse the XML file and store the data into a database

            System.out.println("XML file parsed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}