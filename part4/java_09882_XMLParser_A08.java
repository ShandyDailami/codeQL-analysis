import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_09882_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            FileReader fileReader = new FileReader(xmlFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileReader);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element: " + eElement.getTagName());
                    System.out.println("Attributes: ");
                    for (int j = 0; j < eElement.getAttributes().getLength(); j++) {
                        System.out.println("Attribute " + (j + 1) + ": "
                                + eElement.getAttributes().item(j).getNodeName() + " = "
                                + eElement.getAttributes().item(j).getNodeValue());
                    }
                }
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}