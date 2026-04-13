import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_33411_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("your_file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;
        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            printNodeInfo(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodeInfo(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Tag name: " + element.getTagName());
                System.out.println("Node text: " + element.getTextContent());
            }
        }
    }
}