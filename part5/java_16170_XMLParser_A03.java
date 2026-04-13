import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16170_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String fileName = "example.xml";
            InputStream is = new FileInputStream(fileName);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(is);
            
            // Your code to process the document goes here

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}