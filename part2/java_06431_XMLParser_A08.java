import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_06431_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";  // Replace with your XML file path

        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element nNode = (Element) nList.item(temp);
                System.out.println("Element Name: " + nNode.getNodeName());
            }
            dBuilder.detachDocument();
        } catch (IOException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}