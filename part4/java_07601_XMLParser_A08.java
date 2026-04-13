import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07601_XMLParser_A08 {
    public static void main(String[] args) {
        String inputFile = "input.xml";
        parseDocument(inputFile);
    }

    private static void parseDocument(String inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            Document document = builder.parse(fis);

            // Continue with the parsing of the XML document...

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}