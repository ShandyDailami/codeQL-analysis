import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29076_XMLParser_A01 {
    public static void main(String[] args) {
        File file = new File("sample.xml"); // replace with your file

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (FileInputStream fis = new FileInputStream(file)) {
            Document document = builder.parse(fis);

            document.getDOmentElement().normalize();

            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            printElement("", document, 1);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(String padding, Node node, int level) {
        String prefix = new String(new char[level]).replace("\0", "--");
        System.out.println(prefix + node.getNodeName() + (node.getNodeType() == Node.ELEMENT_NODE ? ": " : " (element): "));
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            Iterator<Node> children = element.getChildNodes().iterator();
            while (children.hasNext()) {
                printElement(padding + prefix, children.next(), level + 1);
            }
        }
    }
}