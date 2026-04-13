import java.awt.print.PrintJob;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03644_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printElement(doc, doc.getDocumentElement());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Document doc, Element elem) {
        System.out.println("Element name: " + elem.getNodeName());
        System.out.println("Element text: " + elem.getTextContent());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == NodeList.ELEMENT_NODE) {
                printElement((Document) children.item(i), (Element) children.item(i));
            } else if (children.item(i).getNodeType() == NodeList.TEXT_NODE || children.item(i).getNodeType() == NodeList.COMMENT_NODE) {
                System.out.println("Element text: " + children.item(i).getNodeValue());
            }
        }
    }
}