import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_07930_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "your_xml_file_path.xml"; // replace with your XML file path
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("tag"); // replace "tag" with your XML tag

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}