import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_13934_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printTagsAndValues(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printTagsAndValues(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Tag: " + eElement.getTagName());
                System.out.println("Value: " + eElement.getTextContent());
            }
        }
    }
}