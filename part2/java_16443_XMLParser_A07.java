import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_16443_XMLParser_A07 {
    private static final String AUTH_FAILURE_ATTRIBUTE = "authFailure";

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFilePath));

            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getAttributes().getNamedItem(AUTH_FAILURE_ATTRIBUTE) != null) {
                    System.out.println("Parsing node: " + node.getNodeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}