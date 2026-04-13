import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import javax.xml.transform.stream.StreamSource;

public class java_28323_XMLParser_A08 {

    public static void main(String[] args) {
        // Initialize DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation

        // Initialize Validator
        Validator validator = factory.newValidator();

        // Load XML Document
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new StreamSource(new StringReader("YOUR_XML_HERE")));

        // Validate XML
        validator.validate(document);
    }
}