import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08164_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList authFailures = document.getElementsByTagName("AuthFailure");
            for (int i = 0; i < authFailures.getLength(); i++) {
                System.out.println("Warning: An authorization failure was found in the XML file!");
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}