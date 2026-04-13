import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_12705_XMLParser_A03 {

    public void parseXml(String fileName) {

        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String tagName = element.getTagName();
                System.out.println("Tag Name: " + tagName);
                String attributeValue = element.getAttribute("id");
                if (attributeValue != null && attributeValue.length() > 0) {
                    System.out.println("Attribute id: " + attributeValue);
                }
                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.TEXT_NODE && childNode.getTextContent().trim().length() > 0) {
                        System.out.println("Child node text: " + childNode.getTextContent());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        xmlParser.parseXml("sample.xml");
    }
}