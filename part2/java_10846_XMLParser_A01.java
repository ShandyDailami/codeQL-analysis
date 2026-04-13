import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_10846_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        try {
            parseXmlFile(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(File xmlFile) throws IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        // Now, you can navigate the XML document using the DOM API or other methods
        // For instance, to print all element names:
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());
    }
}