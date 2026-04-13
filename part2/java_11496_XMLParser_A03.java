import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11496_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation for now
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML document
        Document doc = null;
        try {
            doc = builder.parse("sample.xml"); // Replace with your XML file
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }

        // Here you can add code to process the parsed document
        // e.g., print all element names
        System.out.println("Element names:");
        for (int i = 0; i < doc.getElements().getLength(); i++) {
            System.out.println(doc.getElements().item(i).getNodeName());
        }
    }
}