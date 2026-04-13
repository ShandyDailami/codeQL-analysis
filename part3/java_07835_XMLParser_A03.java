import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

public class java_07835_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_xml_file.xml"; // replace with your xml file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new java.io.File(file)));
            document.getDOCUMENT_NODE().normalize();

            List<String> nodes = document.getElementsByTagName("node").stream()
                    .map(node -> node.getChildNodes())
                    .flatMap(NodeList::stream)
                    .map(node -> node.getNodeName())
                    .collect(Collectors.toList());

            System.out.println("XML File Content:");
            nodes.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}