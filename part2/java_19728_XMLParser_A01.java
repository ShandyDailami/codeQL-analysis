import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19728_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXMLFile("secure_file.xml");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String fileName) throws IOException, ParserConfigurationException, SAXException {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        // Here you can perform security-sensitive operations related to BrokenAccessControl.
        // For now, we're just printing the document element.
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
    }
}