import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17449_XMLParser_A01 {

    public static void main(String[] args) {
        String fileName = "sample.xml"; // Your file name here
        File inputFile = new File(fileName);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write your security-sensitive operations here
        // For example, you might want to check the document's root element
        if (doc.getDocumentElement().getNodeName().equals("root")) {
            System.out.println("Document root element is 'root'");
        } else {
            System.out.println("Document root element is not 'root'");
        }
    }
}