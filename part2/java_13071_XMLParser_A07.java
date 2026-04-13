import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_13071_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("*");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                System.out.println("Tag : " + nList.item(temp).getNodeName() + "  Content : " + nList.item(temp).getTextContent());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}