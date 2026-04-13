import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34807_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the document (remove namespaces) (optional)
            doc.getDocumentElement().normalize();
            printXML(doc);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printXML(Document doc) {
        System.out.println("Printing XML contents");
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("  - Node: " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("    Element: " + eElement.getTagName());
                System.out.println("    Attributes: " + eElement.getAttributes().getLength());
            } else if (nNode.getNodeType() == Node.TEXT_NODE) {
                Text tNode = (Text) nNode;
                System.out.println("    Text: " + tNode.getNodeValue());
            }
        }
    }
}