import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_40937_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // Path to your XML file
        String xsdFile = "sample.xsd"; // Path to your XSD file

        try {
            validateXmlAgainstXsd(xmlFile, xsdFile);
        } catch (Exception e) {
            System.out.println("Invalid XML. Reason: " + e.getMessage());
        }
    }

    private static void validateXmlAgainstXsd(String xmlFile, String xsdFile) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true); // Enable validation
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File(xsdFile));
        Validator validator = schema.newValidator();

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(xmlFile));

        validator.validate(document);
        System.out.println("Valid XML");
    }
}