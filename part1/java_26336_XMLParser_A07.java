import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_26336_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("src/test.xml");
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileName));

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("node");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node: " + nodeList.item(i).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}