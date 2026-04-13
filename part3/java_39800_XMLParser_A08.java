import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.StringReader;

public class java_39800_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<document></document>"; // Your XML data here
        String xsd = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                "  <xs:element name=\"document\" type=\"xs:string\" />\n" +
                "</xs:schema>"; // Your XSD data here

        validateXmlAgainstXsd(xml, xsd);
    }

    private static void validateXmlAgainstXsd(String xml, String xsd) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new Source[]{new StringReader(xsd)});
            Validator validator = schema.newValidator();
            XMLStreamReader reader = XMLStreamUtils.createXMLStreamReader(xml);
            validator.validate(reader);

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.EVENT_CHARACTERS) {
                    String characters = reader.getText();
                    // Do something with characters...
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}