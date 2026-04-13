import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_36706_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use this factory to construct Document objects
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file into a Document object
            Document doc = dBuilder.parse(getInputStream("sample.xml"));

            // TODO: Process the document here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}