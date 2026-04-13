import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

public class java_33203_XMLParser_A07 {
    private static final String XML_FILE_PATH = "src/main/resources/sample.xml"; // replace with your file path

    public static void main(String[] args) {
        validateXMLFile();
    }

    private static void validateXMLFile() {
        File xmlFile = new File(XML_FILE_PATH);
        ValidatorFactory factory = ValidatorFactory.newInstance();
        Validator validator = factory.getValidator();
        try {
            ValidatorHandler handler = validator.getHandler();
            ValidatorHandler.Level level = handler.getValidationLevel();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.validate(level, new SAXParseExceptionListener());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXParseExceptionListener implements ValidatorHandler.SAXParseExceptionListener {
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void fatalError(SAXParseException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}