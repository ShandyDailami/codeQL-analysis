import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_13668_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(xmlFilePath));

            // You can now process the document, for instance, extract the value of a specific element
            document.getElementsByTagName("tag_name").item(0).getTextContent();

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}