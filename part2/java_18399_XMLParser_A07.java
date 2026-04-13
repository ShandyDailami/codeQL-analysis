import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_18399_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // You can now manipulate the document here
            // For example, you can print all element names and attributes
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}