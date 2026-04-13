import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24214_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(getFileAsInputStream("example.xml"));

            // TODO: Process the parsed XML data

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getFileAsInputStream(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (Exception e) {
            System.out.println("Error reading file: " + fileName);
            return null;
        }
    }
}