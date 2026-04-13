import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_41268_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";
        File xmlFile = new File(xmlFilePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            printNodes(doc, doc.getDocumentElement());

            // Add your security-sensitive operations here

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(Document doc, org.w3c.dom.Node node) {
        String indent = "    ";

        System.out.println(indent + node.getNodeName());

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printNodes(doc, children.getItem(i));
        }
    }
}