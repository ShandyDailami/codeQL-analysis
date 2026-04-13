import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_31041_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element : " + element.getNodeName());
                    System.out.println("Attribute : " + element.getAttribute("name"));
                    System.out.println("Value : " + element.getTextContent());
                }
           
            }
            System.out.println("XML Parsing Finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}