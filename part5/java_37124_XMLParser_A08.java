import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_37124_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Print the parsed information
            printDocument(doc);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static void printDocument(Document doc) {
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
    }
}