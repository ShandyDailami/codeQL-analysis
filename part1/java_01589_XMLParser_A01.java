import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_01589_XMLParser_A01 {

    public static Document getDocument(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) {
        String fileName = "example.xml"; // replace with your file name
        Document doc = getDocument(fileName);
        // now you can work with the parsed document
    }
}