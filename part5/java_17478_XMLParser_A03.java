import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17478_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "path/to/your/xml/file.xml";  // replace with your file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Here you can perform operations on the parsed XML document
            // For instance, print all element names
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Security-sensitive operations related to injection
            // Do not include any injection code here, only print the parsed XML document
            System.out.println("\nParsed XML Document:");
            printDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            dBuilder.parse(new InputSource(new StringReader(doc.getFirstChild().getNodeName())));
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }
}