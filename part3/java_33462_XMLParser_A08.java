import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

public class java_33462_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            List<String> dataList = new ArrayList<>();
            extractData(doc, "node_name", dataList);

            for (String data : dataList) {
                System.out.println(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc, String nodeName, List<String> dataList) {
        NodeList nodeList = doc.getElementsByTagName(nodeName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                dataList.add(element.getTextContent());
            }
        }
    }
}