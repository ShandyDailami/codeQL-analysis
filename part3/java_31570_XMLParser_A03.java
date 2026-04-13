import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class java_31570_XMLParser_A03 {
    public static void main(String[] args) {
        File schemaFile = new File("schema.xsd");
        File xmlFile = new File("input.xml");

        try {
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(false);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document doc = documentBuilder.parse(xmlFile);
            validator.validate(doc);
            System.out.println("The document is valid.");

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}