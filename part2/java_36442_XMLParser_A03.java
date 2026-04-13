import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.transform.Transformer;
import javax.xml.transform.Transformers;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class java_36442_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";
        String xsdFilePath = "path/to/your/xsd/file.xsd";

        // Step 1: Validate XML with XSD
        try {
            URI xsdUri = new File(xsdFilePath).toURI();
            Validator validator = DocumentBuilderFactory.newInstance().newValidator();
            validator.setSchema(new Schema(xsdUri));
            validator.validate(new StreamSource(new File(xmlFilePath)));
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
            return;
        }

        // Step 2: Parse XML
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true); // Enables support for XML namespaces

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));

            // Step 3: Extract specific data
            NodeList nodes = document.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                // Perform security-sensitive operations here, like extracting values from the node
                // ...
            }

            // Step 4: Validate again with XSD to ensure parsing was successful
            try {
                validator.validate(new StreamSource(document));
            } catch (SAXException e) {
                System.out.println("Parsing error: " + e.getMessage());
                return;
            }

            // Step 5: Transform XML to another format (for example, print to console)
            Transformer transformer = Transformers.getTransformerInstance(new StreamResult(System.out));
            transformer.transform(new StreamSource(document));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Parsing and validation successful!");
    }
}