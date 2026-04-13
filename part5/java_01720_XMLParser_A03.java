import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_01720_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // Change this to your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
       
        }

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Tag: " + element.getTagName());
            }
        }
    }
}