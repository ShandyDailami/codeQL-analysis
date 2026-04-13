import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class java_07503_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new StreamSource(new String[] {"input.xml"}));

            // Load the XML schema
            SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = sf.newSchema(new File("schema.xsd")); // replace with your schema file
            Validator validator = schema.newValidator();

            // Validate the XML document
            validator.validate(new Source(new StreamSource(new String[] {"input.xml"}))); // replace with your xml file

            System.out.println("The XML document is valid.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}