import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08879_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try (FileReader reader = new FileReader(inputFile)) {
            Document doc = dBuilder.parse(reader);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Element element) {
        System.out.println("Element : " + element.getNodeName());

        org.w3c.dom.NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                org.w3c.dom.Element elementNode = (org.w3c.dom.Element) node;
                printElement(elementNode);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text Node : " + node.getNodeValue());
            }
        }
    }
}