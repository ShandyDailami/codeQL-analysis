import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;
import java.io.IOException;

public class java_33128_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String value = element.getElementsByTagName("value").item(0).getTextContent();
                System.out.println("Name: " + name + ", Value: " + value);
            }
        }
    }
}