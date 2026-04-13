import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_05849_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // path to your XML file
            FileReader reader = new FileReader(xmlFile);
            
            // create a factory for the DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // parse the XML file
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // get the list of elements
            NodeList nList = doc.getElementsByTagName("*");
            
            // print out the names of all elements
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Element Name: " + eElement.getNodeName());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}