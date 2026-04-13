import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_18058_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        }
        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element: " + eElement.getTagName());
                System.out.println("Attribute: " + eElement.getAttribute("name"));
                System.out.println("Value: " + eElement.getAttribute("value"));
            }
        }
    }
}