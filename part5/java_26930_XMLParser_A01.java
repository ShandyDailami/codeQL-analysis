import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_26930_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your xml file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // print the XML file
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("").item(0).getTextContent());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}