import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class java_21732_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file";
        List<String> sensitiveOperationList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("tag");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String sensitiveOperation = eElement.getAttribute("attribute");
                    if (sensitiveOperation != null) {
                        sensitiveOperationList.add(sensitiveOperation);
                    }
                }
            }

            // Printing out the sensitive operations
            for (String operation : sensitiveOperationList) {
                System.out.println("Found sensitive operation: " + operation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}