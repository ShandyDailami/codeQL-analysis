import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class java_18945_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String xmlFile = "src/main/resources/sample.xml";
            parseXMLFile(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String fileName) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileName);

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Tag : " + nodeList.item(i).getNodeName() + "   Content : " + nodeList.item(i).getTextContent());
        }
    }
}