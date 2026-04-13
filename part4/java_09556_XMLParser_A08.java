import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09556_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Creating a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Creating a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Creating a Document
            Document doc = builder.parse(getXmlFile("sample.xml"));

            // Process Document here. For simplicity, we're just printing
            // the document's root element.
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getXmlFile(String filename) {
        try {
            InputStream input = new FileInputStream(filename);
            return input;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}