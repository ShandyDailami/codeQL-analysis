import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_06502_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("Element");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            Element element = (Element) node;
            System.out.println("Element Name: " + element.getElementsByTagName("Name").item(0).getTextContent());
            System.out.println("Element Value: " + element.getElementsByTagName("Value").item(0).getTextContent());
        }
    }
}