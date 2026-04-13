import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class java_17453_XMLParser_A03 {

    public static void main(String[] args) {
        String file = "example.xml";
        parse(file);
    }

    private static void parse(String file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodes = doc.getElementsByTagName("node");
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getTextContent());
        }
    }
}