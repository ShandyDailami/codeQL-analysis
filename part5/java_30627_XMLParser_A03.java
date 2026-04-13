import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_30627_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "data.xml"; // path to your xml file
        String xsdFilePath = "schema.xsd"; // path to your xsd file

        // Load XML file and Schema
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        Validator validator = builder.getValidator();
        Schema schema = validator.getReferenceSchema(xsdFile);

        // Validate XML
        try {
            validator.validate(doc, schema);
            System.out.println("XML is valid");
        } catch (SAXException e) {
            System.out.println("XML is invalid");
        }

        // Transform XML to pretty-print
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        // Do something with the parsed XML
    }
}