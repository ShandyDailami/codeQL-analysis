import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_38358_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();

            printElement(doc, doc.getDocumentElement());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element element) {
        System.out.println("Element name: " + element.getNodeName());

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Document) doc, (Element) node);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Element content: " + node.getNodeValue());
            }
        }
    }
}