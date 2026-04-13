import java.io.File;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01061_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        String schemaFile = "example.xsd";

        // Load the schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema;
        try {
            schema = factory.newSchema(new File(schemaFile));
        } catch (Exception e) {
            System.out.println("Failed to load schema: " + e.getMessage());
            return;
        }

        // Validate the XML
        Validator validator = schema.newValidator();
        DefaultHandler handler = new DefaultHandler();
        try {
            validator.validate(new SAXSource(handler, new SAXParserFactory().newSAXParser()));
        } catch (Exception e) {
            System.out.println("Failed to validate XML: " + e.getMessage());
            return;
        }

        System.out.println("XML is valid.");
    }
}