import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_18613_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";
        String xsdFile = "/path/to/your/xsd/file.xsd";

        try {
            validateXmlAgainstXSD(xmlFile, xsdFile);
            parseAndTransform(xmlFile, xsdFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateXmlAgainstXSD(String xmlFile, String xsdFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Schema schema = builder.buildSchema(new File(xsdFile));
        Validator validator = schema.newValidator();

        Document document = builder.parse(new File(xmlFile));
        validator.validate(document);

        System.out.println("XML is valid against XSD");
    }

    private static void parseAndTransform(String xmlFile, String xsdFile) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlFile));

        // Add your operations here to manipulate the document

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        Schema schema = builder.buildSchema(new File(xsdFile));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, schema.getDocumentElement().getQualifiedName());

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);

        transformer.transform(source, result);
    }
}