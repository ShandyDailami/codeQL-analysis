import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;
import java.io.File;
import java.io.IOException;

public class java_10723_XMLParser_A01 {

    private static final String XML_FILE_PATH = "path_to_your_xml_file.xml";

    public static void main(String[] args) {
        parseXMLFile(XML_FILE_PATH);
    }

    private static void parseXMLFile(String xmlFilePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new StreamSource(new File(xmlFilePath)));
            validateXML(document);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void validateXML(Document document) {
        ValidatorHandler validatorHandler = new ValidatorHandler();
        Validator validator = validatorHandler.newValidator();

        try {
            validator.validate(new StreamSource(new File(XML_FILE_PATH)));
            System.out.println("XML file is valid.");
        } catch (IOException | SAXException e) {
            System.out.println("Error validating XML file.");
            e.printStackTrace();
        }
    }
}