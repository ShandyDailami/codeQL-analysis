import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35715_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // step 1: load the xml file
            InputStream input = new FileInputStream("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(input);
            
            // step 2: extract sensitive data
            // This is a very naive example, it just extracts the text from the XML
            // In a real-world scenario, you would need to parse the XML and extract
            // sensitive data more securely.
            String sensitiveData = doc.getElementsByTagName("sensitiveData").item(0).getTextContent();
            
            // step 3: print the sensitive data
            System.out.println("Sensitive Data: " + sensitiveData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}