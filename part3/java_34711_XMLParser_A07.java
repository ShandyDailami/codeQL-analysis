import java.io.File;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.FileReader;

public class java_34711_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");  // Input XML file
            FileReader reader = new FileReader(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Get root element
            Element root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // Get all child nodes
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Child element: " + element.getNodeName());
                    System.out.println("Child element value: " + element.getFirstChild().getNodeValue());
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}