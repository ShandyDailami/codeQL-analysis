import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_40366_XMLParser_A01 {
    public static void main(String[] args) {
        String filePath = "example.xml"; // replace with your file path
        parseXmlFile(filePath);
    }

    public static void parseXmlFile(String filePath) {
        try {
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Prints the parsed content of the document
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElements().get(0).getNodeName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}