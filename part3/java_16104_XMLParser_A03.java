import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_16104_XMLParser_A03 {

    public static void main(String[] args) {
        parseXML("src/data.xml");
    }

    private static void parseXML(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("node");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String nodeName = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String nodeValue = eElement.getElementsByTagName("value").item(0).getTextContent();

                    System.out.println("Node name: " + nodeName);
                    System.out.println("Node value: " + nodeValue);
                }
            }

            FileWriter file = new FileWriter("output.txt");
            file.write("XML file parsed successfully");
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}