import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_35041_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/data.xml"; // Replace with your XML file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            File xml = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");

            for (int i = 0; i < userList.getLength(); i++) {
                System.out.println("User: " + i + 1);
                System.out.println("Name: " + userList.item(i).getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Email: " + userList.item(i).getElementsByTagName("email").item(0).getTextContent());
                System.out.println("Role: " + userList.item(i).getElementsByTagName("role").item(0).getTextContent());
                System.out.println("--------------------------------");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}