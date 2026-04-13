import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_29993_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printTagInfo(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTagInfo(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String tagName = element.getTagName();
                String value = element.getFirstChild().getNodeValue();
                System.out.println("Tag: " + tagName + ", Value: " + value);
            }
        }
    }
}