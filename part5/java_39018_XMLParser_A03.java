import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.validation.ValidatorHandler;

public class java_39018_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";
        String xsdFile = "src/main/resources/example.xsd";

        try {
            validateXmlAgainstXsd(xmlFile, xsdFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void validateXmlAgainstXsd(String xmlFile, String xsdFile) throws SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        ValidatorHandler vh = (ValidatorHandler) factory.getValidatorHandler();
        Validator validator = vh.getValidator();
        validator.setSchema(new StreamSource(new java.io.File(xsdFile)));

        validator.validate(doc);
    }
}