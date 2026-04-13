import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_33063_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "your_xml_file.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            List<String> tagNames = document.getElements().stream()
                    .map(e -> e.getNodeName())
                    .collect(Collectors.toList());

            // do something with the parsed XML data, like print tag names
            System.out.println("Tag names: " + tagNames);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}