import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_04548_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourfile.xml"); // replace with your XML file path
            FileReader reader = new FileReader(xmlFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(reader);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element: " + eElement.getTagName());
                    System.out.println("Text: " + eElement.getTextContent());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}