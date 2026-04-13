import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22406_XMLParser_A03 {

    public static void main(String[] args) {

        // Creating DocumentBuilderFactory instance
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            // Creating DocumentBuilder instance
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsing the XML file
            Document doc = dBuilder.parse("sample.xml");

            // Print the parsed data
            printDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println("\nRecords in the document:\n");

        // Iterate through the child nodes of the document
        doc.getElementsByTagName("record").item(0).getChildNodes().item(0).getNodeValue()
    }
}