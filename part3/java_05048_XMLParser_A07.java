import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class java_05048_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_file.xml"; // replace with your xml file path
        File xmlFileToBeOpened = new File(xmlFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(xmlFileToBeOpened);
            doc.getDocumentElement().normalize();

            // Security-sensitive check
            NodeList nl = doc.getElementsByTagName("authFailure");
            for (int temp = 0; temp < nl.getLength(); temp++) {
                Element element = (Element) nl.item(temp);
                String authFailureData = element.getTextContent();

                if (authFailureData.contains("sensitive_info")) {
                    System.out.println("Security-sensitive operation related to A07_AuthFailure detected.");
                    break;
                }
            }

            // Print elements and attributes
            printElementsAndAttributes(doc, doc.getElementsByTagName("*"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc, NodeList nodes) {
        for (int temp = 0; temp < nodes.getLength(); temp++) {
            Node node = nodes.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Tag : " + element.getTagName());
                System.out.println("Attributes : ");

                Attributes attributes = element.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    System.out.println(attributes.item(j).getNodeName() + " = " + attributes.item(j).getTextNode().getNodeValue());
                }
            }
        }
    }
}