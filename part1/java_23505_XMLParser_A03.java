import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class java_23505_XMLParser_A03 {

    public static void main(String[] args) {

        try {
            File schemaFile = new File("schema.xsd");  // Your schema file
            File xmlFile = new File("input.xml");     // Your input file

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            validator.validate(new StreamSource(xmlFile));

            System.out.println("The document is valid.");

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}