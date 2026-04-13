import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_07868_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourfile.xml"); // replace with your file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element name: " + eElement.getTagName());
                    System.out.println("Element value: " + eElement.getTextContent());
                }
           
            }
            dBuilder = null;
            dbFactory = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}