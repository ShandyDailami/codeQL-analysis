import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class java_37136_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            validateXMLSchema(new File("schema.xsd"), new File("input.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateXMLSchema(File schemaFile, File inputFile) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(inputFile));
    }

    private static Document parseXML(String fileName) throws SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidate(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        return doc;
    }

}