import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28315_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String filePath = "path_to_your_xml_file"; // replace with your file path
            parseXML(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String filePath) throws IOException {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            String elementName = node.getNodeName();
            System.out.println("Element Name : " + elementName);
        }
    }
}