import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_07696_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // replace with your file path

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // print out the XML content
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElements().getItem(0).getNodeName());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}