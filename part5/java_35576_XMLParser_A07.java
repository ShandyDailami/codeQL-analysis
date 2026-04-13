import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class java_35576_XMLParser_A07 {
    public static void main(String[] args) {
        // Step 1: Parse XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));
            System.out.println("XML Parsed Successfully.");

            // Step 2: Validate XML
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new File("path_to_your_xml_schema.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("path_to_your_xml_file.xml")));
            System.out.println("XML Validated Successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}