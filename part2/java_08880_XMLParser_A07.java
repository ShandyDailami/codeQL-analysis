import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_08880_XMLParser_A07 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("sample.xml")); // replace with your file

            document.getDOCUMENT_NODE().normalize();

            NodeList nodeList = document.getElementsByTagName("*");

            System.out.println("--- Start of XML ---");

            for (int i = 0; i < nodeList.getLength(); i++) {
                printNode(nodeList.item(i));
            }

            System.out.println("--- End of XML ---");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node) {

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;

            System.out.println("Element: " + element.getNodeName());

            Iterator it = element.getAttributes().getNamespacesDeclarations();

            while (it.hasNext()) {
                String s = (String) it.next();
                System.out.println("Namespace: " + s);
            }

            printNode(element);

        } else if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println("Text: " + node.getNodeValue());

        }
    }
}