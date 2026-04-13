import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_14900_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // Path to your XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getElementsByTagName("root").item(0).getTextContent());

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}