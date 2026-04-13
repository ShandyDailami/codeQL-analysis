import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;

public class java_26160_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File schemaFile = new File("example.xsd"); // Path to the XML schema file
            File xmlFile = new File("example.xml"); // Path to the XML file

            validateXMLSchema(schemaFile, xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateXMLSchema(File schemaFile, File xmlFile) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Schema schema = builder.buildSchema(new StreamSource(schemaFile));
        builder.setSchema(schema);

        Document document = builder.parse(xmlFile);
        System.out.println("The document is valid");
    }
}