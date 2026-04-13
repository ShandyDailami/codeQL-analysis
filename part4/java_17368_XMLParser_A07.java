import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17368_XMLParser_A07 {
    public static void main(String[] args) {
        // Step 1: Initialize DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Step 2: Create a DocumentBuilder using factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Step 4: Print the parsed XML
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}