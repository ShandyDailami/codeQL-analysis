import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_08413_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parse(xmlFile);
    }

    public static void parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        document.getDocumentElement().normalize();

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getNodeName());

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.TEXT_NODE) {
                        System.out.println("Text: " + childNode.getNodeValue());
                    }
                }
            }
        }
    }
}