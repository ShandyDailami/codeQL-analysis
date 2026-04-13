import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_33738_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and set it to use the default security settings
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(false);
            factory.setXIncludeSchemaResolver(null);
            factory.setXQuack(false);
            factory.setAccessExternalSchema(false);

            // Get a new DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and store the result in a Document object
            Document document = builder.parse("path_to_your_xml_file");

            // Here you can handle the document object as needed. For example, print the XML file's content.

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}