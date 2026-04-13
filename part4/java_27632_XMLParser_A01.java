import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27632_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the XML file
            Document document = builder.parse("path_to_your_xml_file.xml");

            // Here you can add your code to parse and access data from the XML file

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}