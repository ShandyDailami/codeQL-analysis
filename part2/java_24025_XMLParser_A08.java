import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_24025_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            // Print out the XML tags
            printTags(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printTags(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element e = (Element) nList.item(temp);
            System.out.println("Tag: " + e.getTagName());
        }
    }
}