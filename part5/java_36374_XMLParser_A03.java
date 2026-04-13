import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_36374_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // create DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // get the root element
            doc.getDocumentElement().normalize();

            // print all element and their attributes
            printElements(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp != nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                // print element name and value
                System.out.println("Element: " + eElement.getNodeName() + ", Value: " + eElement.getAttribute("value"));
            }
        }
    }
}