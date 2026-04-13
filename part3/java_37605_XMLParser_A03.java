import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_37605_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Extract sensitive information and print it
        extractSensitiveInfo(doc);
    }

    private static void extractSensitiveInfo(Document doc) {
        NodeList nList = doc.getElementsByTagName("sensitive_info");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Sensitive Info: " + nNode.getTextContent());
        }
    }
}