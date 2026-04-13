import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_05015_XMLParser_A08 {

    public void parseXML(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\nNode Name: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Attributes: " + element.getAttribute("id"));
            }
        }
    }

    public static void main(String[] args) {
        VanillaXMLParser parser = new VanillaXMLParser();
        parser.parseXML("sample.xml");  // replace with your XML file path
    }
}