import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_07556_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        System.out.println("Root element : " + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\n  Node Type : " + node.getNodeType());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("  Employee ID : " + element.getAttribute("id"));
                System.out.println("  Employee Name : " + element.getAttribute("name"));
            }
        }
    }
}