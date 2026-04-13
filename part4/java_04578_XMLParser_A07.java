import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_04578_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("test.xml");
            FileReader reader = new FileReader(xmlFile);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("note");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Note #" + (i + 1));
                System.out.println("Title: " + getNodeValue(node, "title"));
                System.out.println("Description: " + getNodeValue(node, "description"));
                System.out.println("------------------------");
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNodeValue(Node node, String elementName) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getElementsByTagName(elementName).item(0).getTextContent();
        }
        return null;
    }
}