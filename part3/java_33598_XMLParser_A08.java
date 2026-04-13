import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.validation.ValidationConfiguration;
import javax.xml.validation.Validator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;

public class java_33598_XMLParser_A08 {
    private static final String SCHEMA_TEMPLATE = "<schema xmlns='http://www.w3.org/2001/XMLSchema'>%s</schema>";
    private static final String INVALID_XML_TEMPLATE = "<invalid-xml>%s</invalid-xml>";

    public static void main(String[] args) {
        // Create a schema string
        String schema = "<schema xmlns='http://www.w3.org/2001/XMLSchema'>\n" +
                "<element name='test' type='string'/>\n" +
                "</schema>";

        // Create an XML string
        String xml = "<test>Invalid XML</test>";

        // Generate the schema and XML string with a comment
        System.out.println(String.format(SCHEMA_TEMPLATE, schema));
        System.out.println(String.format(INVALID_XML_TEMPLATE, xml));

        // Validate the XML string
        Validator validator = getValidator(schema);
        SAXParser saxParser = getSAXParser();

        boolean isValid = validator.validate(new StringReader(xml));
        System.out.println("Is the XML valid? " + isValid);
    }

    private static SAXParser getSAXParser() {
        try {
            return SAXParserFactory.newInstance().newSAXParser(new DTDHandler());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Validator getValidator(String schema) {
        try {
            ValidationConfiguration validationConfig = ValidationConfiguration.newInstance();
            return validationConfig.newSchemaValidator(schema);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class DTDHandler extends DefaultHandler {
        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}