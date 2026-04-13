import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_32580_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("example.xml"));

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

    private static void printElement(Document doc, Element element) {
        System.out.println("Element: " + element.getNodeName());

        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.item(i).getNodeName() + "=" + attributes.item(i).getTextContent());
        }

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + children.item(i).getNodeValue());
            } else {
                printElement((Document) children.item(i), (Element) children.item(i));
            }
        }
    }
}