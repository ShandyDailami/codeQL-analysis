import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_25565_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // path to your XML file
        String xsdFile = "schema.xsd"; // path to your XSD file

        File xsdFileAsFile = new File(xsdFile);
        File xmlFileAsFile = new File(xmlFile);

        // Step 1: Validate XML file with XSD file
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            ValidatorHandler validatorHandler = builder.getValidatorHandler();
            Validator validator = validatorHandler.getEffectiveValidator();
            validator.setErrorHandler(validatorHandler);

            SAXParser saxParser = builder.newSAXParser();
            saxParser.parse(new StreamSource(xmlFileAsFile), new XmlValidator(validator));

        } catch (SAXException | IOException e) {
            System.out.println("Error validating XML file: " + e.getMessage());
            return;
        }

        // Step 2: Parse XML file
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFileAsFile);

            // Your logic here...

        } catch (SAXException | IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
            return;
        }
    }
}

class XmlValidator implements ValidatorHandler {
    private final Validator validator;

    public java_25565_XMLParser_A08(Validator validator) {
        this.validator = validator;
    }

    @Override
    public ValidatorHandler getEffectiveValidator() {
        return this;
    }

    @Override
    public boolean validates(String namespaceURI, String localName) throws SAXException {
        return validator.validate(new StreamSource(new StringReader(namespaceURI + localName)));
    }

    @Override
    public boolean validates(String namespaceURI, String localName, Object instance) throws SAXException {
        return validator.validate(new StreamSource(new StringReader(namespaceURI + localName + instance.toString())));
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}