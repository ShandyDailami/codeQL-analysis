import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_30993_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXMLFile("example.xml");
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Parsing failed due to: " + e.getMessage());
        }
    }

    public static void parseXMLFile(String fileName) throws IOException, SAXException {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        SchemaFactory sFactory = dbFactory.newSchemaFactory();

        Schema schema = sFactory.newSchema(new StreamSource(new File("schema.xsd")));

        Document document = dBuilder.parse(xmlFile);

        document.getDocumentElement().normalize();

        document.validate(schema);

        System.out.println("The document is valid.");
    }
}