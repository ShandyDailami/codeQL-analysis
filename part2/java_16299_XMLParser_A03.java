import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_16299_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";  // replace with your xml file path
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Here you can add your parsing logic
            // For example, let's print all element names
            printElementNames(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document doc) {
        doc.getElementsByTagName("*").item(0).getNodeName();
        // Continue parsing and printing element names
    }
}