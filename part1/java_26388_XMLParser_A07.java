import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_26388_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("item");
            Iterator<?> iterator = nodeList.iterator();

            while(iterator.hasNext()) {
                Node node = iterator.next();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String value = element.getElementsByTagName("value").item(0).getTextContent();
                    System.out.println("Name: " + name + ", Value: " + value);
                }
            }

            System.out.println("Parsing completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}