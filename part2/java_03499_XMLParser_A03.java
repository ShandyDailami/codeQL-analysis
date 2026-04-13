import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03499_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            InputStream input = new FileInputStream(inputFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(input);

            // Handle the document here
            System.out.println("Document loaded successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}