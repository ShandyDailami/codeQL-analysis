import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_15437_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("src/example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fis);
        doc.getDocumentElement().normalize();
        printNode(doc.getDocumentElement());
    }

    private static void printNode(Element node) {
        System.out.println("Node name: " + node.getNodeName());
        System.out.println("Node value: " + node.getNodeValue());

        List<Element> childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.size(); i++) {
            Element childNode = (Element) childNodes.get(i);
            printNode(childNode);
        }
    }
}