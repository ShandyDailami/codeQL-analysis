import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_06826_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_file.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);

            // TODO: Parse the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}