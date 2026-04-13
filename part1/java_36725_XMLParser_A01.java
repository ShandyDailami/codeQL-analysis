import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_36725_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your xml file
        parseXml(xmlFile);
    }

    public static void parseXml(String xmlFile) {
        File xml = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Tag: " + eElement.getTagName());
                    System.out.println("Content: " + eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}