import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34926_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML schema
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(new java.io.File("path_to_your_schema.xsd"));

            // Load the XML document
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setSchema(schema);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("path_to_your_xml_file.xml");

            // Here, you can validate the document if needed. 
            // If the document is valid, no exception will be thrown.

            System.out.println("XML is valid");

        } catch (SAXException | IOException e) {
            System.out.println("XML is not valid");
            e.printStackTrace();
        }
    }
}