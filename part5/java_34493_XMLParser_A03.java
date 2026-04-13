import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34493_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml"; // replace with your XML file path

        // Step 1: Create a DocumentBuilderFactory and set it to handle unknown elements
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // enable validation
        factory.setNamespaceAware(true); // enable namespace aware parsing

        // Step 2: Use DocumentBuilderFactory to create a Document
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        // Step 3: Create a Validator using the document
        Validator validator = document.getDOMImplementation().getDOMImplementation().getValidator();

        // Step 4: Perform XML validation
        try {
            validator.validate(document);
            System.out.println("XML file is valid");
        } catch (SAXException e) {
            System.out.println("XML file is not valid: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}