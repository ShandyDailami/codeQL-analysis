import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_41072_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("path_to_your_file.xml"));

            // Get the 'username' and 'password' nodes
            NodeList nodeList = doc.getElementsByTagName("username");
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                System.out.println("Username: " + element.getFirstChild().getNodeValue());
            }

            nodeList = doc.getElementsByTagName("password");
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                System.out.println("Password: " + element.getFirstChild().getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}