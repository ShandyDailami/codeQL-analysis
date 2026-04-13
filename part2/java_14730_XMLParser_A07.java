import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14730_XMLParser_A07 {
    public static void main(String[] args) {
        // Step 1: Create DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Get DocumentBuilder from factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file and load into Document
            Document doc = builder.parse("src/main/resources/authfailure.xml");

            // Step 4: Handle the document here, for example, print out all element names
            doc.getElementsByTagName("*").forEach(System.out::println);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}