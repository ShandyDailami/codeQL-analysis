import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_39238_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "sample.xml";  // replace with your xml file
        parseFile(fileName);
    }

    private static void parseFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
       
        }
        doc.getDocumentElement().normalize();
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("  - Node Name: " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("   + Node Value: " + eElement.getFirstChild().getNodeValue());
            }
        }
    }
}