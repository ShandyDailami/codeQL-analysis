import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_15579_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            FileReader reader = new FileReader(xmlFile);
            
            // Creating a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Creating a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Reading the XML file
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            // Printing the XML file
            printElements(doc);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Tag: " + eElement.getTagName());
                System.out.println("Attribute: " + eElement.getAttribute("name"));
                System.out.println("Text: " + eElement.getTextContent());
            }
        }
    }
}