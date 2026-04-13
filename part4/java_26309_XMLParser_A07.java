import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class java_26309_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        String xsdFile = "sample.xsd";

        validateXMLSchema(xmlFile, xsdFile);
    }

    public static void validateXMLSchema(String xmlFile, String xsdFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();

            Document doc = builder.parse(new File(xmlFile));

            // Perform the validation
            validator.validate(doc);

            System.out.println("The document is valid.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}