import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class java_27225_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file";  // Replace with your XML file path

        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);

                // Removing security-sensitive operations related to A03_Injection
                String elementName = element.getElementsByTagName("name").item(0).getTextContent();
                String elementValue = element.getElementsByTagName("value").item(0).getTextContent();

                System.out.println("Element Name: " + elementName);
                System.out.println("Element Value: " + elementValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}