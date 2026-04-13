import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23061_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("myfile.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Here you can add your code to handle the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}