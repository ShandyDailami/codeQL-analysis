import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class java_34535_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // 1. Create a SchemaFactory
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            // 2. Set up a validator
            Validator validator = schemaFactory.newValidator();

            // 3. Set up a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true); // Ensures you can use the 'xmlns' attribute.
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // 4. Set up the Schema
            Schema schema = schemaFactory.newSchema(new File("schema.xsd"));
            validator.setSchema(schema);

            // 5. Parse the XML document
            Document document = dBuilder.parse(new File("input.xml"));

            // 6. Validate the XML document
            validator.validate(document);

            System.out.println("The document is valid.");

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}