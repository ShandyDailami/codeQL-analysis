import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_28954_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // Provide your XML file path here
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("Item - " + (temp + 1));
                System.out.println("Name - " + nodeList.item(temp).getChildNodes().item(0).getNodeValue());
                System.out.println("Description - " + nodeList.item(temp).getChildNodes().item(1).getNodeValue());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}