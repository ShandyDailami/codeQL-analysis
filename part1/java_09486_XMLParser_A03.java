import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_09486_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml");
            FileReader fr = new FileReader(xmlFile);
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(fr);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("element");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    // Print the content of each element
                    System.out.println("Element: " + eElement.getTagName());
                    System.out.println("Content: " + eElement.getTextContent());
                }
            }
            
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}