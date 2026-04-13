import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_14571_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
        validateIntegrityFailure(xmlFile);
    }

    private static void validateIntegrityFailure(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;
        try {
            document = builder.parse(xmlFile);
            NodeList nodeList = document.getElementsByTagName("A08_IntegrityFailure");
            if (nodeList.getLength() != 0) {
                System.out.println("Detected A08_IntegrityFailure in XML file!");
            } else {
                System.out.println("No A08_IntegrityFailure in XML file.");
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}