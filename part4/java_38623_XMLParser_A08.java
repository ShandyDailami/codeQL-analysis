import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_38623_XMLParser_A08 {

    public static void main(String[] args) {
        // Load the XML file
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // Store the data in a map
        Map<String, List<String>> data = parseData(doc);

        // Print the data
        printData(data);

        // Save the data to a new XML file
        saveData(data);
    }

    private static Map<String, List<String>> parseData(Document doc) {
        // Assume we have a root element named 'root' and inside 'root' we have 'child' elements
        List<String> childList = null;
        Map<String, List<String>> data = null;
        NodeList nodeList = doc.getElementsByTagName("child");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            childList = new ArrayList<>();
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                if (childNode.getNodeType() == Node.TEXT_NODE) {
                    childList.add(childNode.getNodeValue());
                }
            }
            data.put("child", childList);
        }
        return data;
    }

    private static void printData(Map<String, List<String>> data) {
        System.out.println("Data: " + data);
    }

    private static void saveData(Map<String, List<String>> data) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            for (Map.Entry<String, List<String>> entry : data.entrySet()) {
                Element childElement = doc.createElement(entry.getKey());
                for (String s : entry.getValue()) {
                    Element sElement = doc.createElement(s);
                    childElement.appendChild(sElement);
                }
                rootElement.appendChild(childElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println();
            System.out.println("Saved to console");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}