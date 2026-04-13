import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15032_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Step 2: Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Step 3: Parse the XML into a Document
            Document doc = builder.parse("src/data.xml"); // Adjust the source XML file path

            // Step 4: Do something with the Document
            // For now, just print the document's details
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}