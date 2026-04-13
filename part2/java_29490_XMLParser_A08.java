// Start of Java code

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class java_29490_XMLParser_A08 {

    public static void parseXmlWithXSD(String xmlFilePath, String xsdFilePath) {

        try {
            // 1. Get the instance of the factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 2. Get the instance of the builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 3. Parse the XML
            Document doc = builder.parse(new StreamSource(new File(xmlFilePath)));

            // 4. Load the schema
            Schema schema = javax.xml.validation.SchemaFactory.newInstance().newSchema(new File(xsdFilePath));

            // 5. Validate the document against the schema
            Validator validator = schema.newValidator();
            validator.validate(doc);

            System.out.println("The XML file is valid against the schema.");

        } catch (SAXException e) {
            System.out.println("The XML file is not valid against the schema.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// End of Java code