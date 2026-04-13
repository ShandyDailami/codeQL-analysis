import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_07405_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Create DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get the builder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML document
            Document doc = builder.parse("path_to_your_xml_file.xml");

            // Step 4: Handle the document, e.g. print the names of all XML tags
            printTagNames(doc);

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static void printTagNames(Document doc) {
        // Step 5: Use the 'getElementsByTagName' method to get all the XML tags
        // and iterate over them, printing their names
        for (int i = 0; i < doc.getElements().getLength(); i++) {
            System.out.println(doc.getElements().item(i).getTagName());
        }
    }
}