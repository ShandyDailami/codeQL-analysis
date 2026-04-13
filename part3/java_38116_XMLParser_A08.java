import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorFactory;

public class java_38116_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file";  // Path to the XML file
        String xsdFile = "/path/to/your/xsd/file";  // Path to the XSD file

        validateXML(xmlFile, xsdFile);
    }

    private static void validateXML(String xmlFile, String xsdFile) {
        try {
            File schemaFile = new File(xsdFile);
            File xmlFileIn = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFileIn);
            doc.getDocumentElement().normalize();
            ValidatorFactory validatorFactory = ValidatorFactory.newInstance();
            Validator validator = validatorFactory.newValidator();
            validator.validate(new StreamSource(schemaFile));
            System.out.println("The document is valid.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}