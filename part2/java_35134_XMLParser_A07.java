import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_35134_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Get the 'name' element
            NodeList nList = doc.getElementsByTagName("name");

            // Extract and print data
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Name: " + nNode.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}