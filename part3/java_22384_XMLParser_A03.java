import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_22384_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File("example.xml");
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        List<Node> nodeList = doc.getElements();

        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println((i + 1) + ". " + nodeList.get(i).getNodeName());
        }
    }
}