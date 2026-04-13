import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18382_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // print the document elements and attributes
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getElementsByTagName("").item(0).getTextContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}