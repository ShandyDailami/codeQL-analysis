import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41913_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // Rest of your code
    }
}