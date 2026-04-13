import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;

public class java_07684_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // Replace with your XML file path
        validateXML(xmlFile);
        parseXML(xmlFile);
    }

    private static void validateXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Validator validator = builder.getDomConfig().getValidator();
            File schema = new File("schema.xsd"); // Schema file for XML validation
            validator.validate(new StreamSource(schema));
            System.out.println("XML is valid");
        } catch (IOException | SAXException e) {
            System.out.println("Error validating XML: " + e.getMessage());
        }
    }

    private static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFile));
            System.out.println("XML Parsed Successfully");
        } catch (IOException | SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}