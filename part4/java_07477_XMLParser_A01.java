import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_07477_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("resources/test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("note");

            System.out.println("--- Notes ---");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("--- Note " + (i + 1) + " ---");

                Node node = nodeList.item(i);

                System.out.println("Title: " + node.getChildNodes().item(1).getFirstChild().getNodeValue());
                System.out.println("Description: " + node.getChildNodes().item(3).getFirstChild().getNodeValue());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}