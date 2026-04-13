import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_18401_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        parseXMLFile(xmlFilePath);
    }

    public static void parseXMLFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        try {
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("login");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String username = element.getAttribute("username");
                String password = element.getAttribute("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}