import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.HashMap;

public class java_15800_XMLParser_A08 {

    public static HashMap<String, String> parse(String fileName) {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("*");
            HashMap<String, String> nodeMap = new HashMap<String, String>();

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node n = nList.item(temp);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    nodeMap.put(e.getNodeName(), e.getAttribute("id"));
                }
            }

            System.out.println(nodeMap);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nodeMap;
    }

    public static void main(String[] args) {
        parse("test.xml");
    }
}