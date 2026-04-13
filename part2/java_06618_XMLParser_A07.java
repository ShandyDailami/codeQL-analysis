import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_06618_XMLParser_A07 {

    public static void main(String[] args) {

        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            printElement(doc.getDocumentElement(), 1);

            System.out.println("\nElements with attribute 'language': ");
            NodeList nl = doc.getElementsByTagName("entry");

            for (int temp = 0; temp < nl.getLength(); temp++) {
                doc.getElementsByTagName("entry")
                 .item(temp)
                 .getAttributes().getNamedItem("language")
                 .getNodeValue();
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Node node, int indent) {

        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + node.getNodeName());

        if (node.hasChildNodes()) {
            for (org.w3c.dom.Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                printElement(child, indent);
            }
        }
    }
}