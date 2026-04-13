import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import java.io.File;
import java.io.IOException;

public class java_30963_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml"); // your input xml file
        File schemaFile = new File("schema.xsd"); // your xml schema file

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); // enable validation
            ValidatorHandler handler = factory.getValidatorHandler();
            Validator validator = handler.getValidator();

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new StreamSource(inputFile));

            // validate the XML against the schema
            if (!validator.validate(new StreamSource(schemaFile))) {
                System.out.println("Validation failed.");
                System.exit(1);
            }

            System.out.println("XML file is valid.");

            // parse the XML for the purpose of security-sensitive operations
            // replace this with your own parsing code

        } catch (SAXException | IOException | org.xml.sax.ParseException e) {
            e.printStackTrace();
        }
    }
}