import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_01925_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printElementsAndAttributes(doc);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element element = (Element) nList.item(temp);
            System.out.println("Element: " + element.getNodeName());

            NodeList attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                System.out.println("Attribute: " + attributes.item(j).getNodeName() + " = " + attributes.item(j).getTextContent());
            }
        }
    }
}