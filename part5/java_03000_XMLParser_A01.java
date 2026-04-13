import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03000_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            
            document.getDocumentElement().normalize();
            NodeList nodes = document.getElementsByTagName("*");
            
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Element: " + nodes.item(i).getNodeName());
                System.out.println("Attributes: " + nodes.item(i).getAttributes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}