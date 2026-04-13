import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15219_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml"); // replace with your file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("root").item(0).getTextContent());
            System.out.println("Child element : " + doc.getElementsByTagName("child").item(0).getTextContent());
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}