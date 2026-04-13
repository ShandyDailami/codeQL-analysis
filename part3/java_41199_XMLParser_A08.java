import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_41199_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File("input.xml");
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParserConfigurationException e3) {
            e3.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.print("Element name : " + eElement.getTagName( ) + " -> ");
                System.out.println("Element value : " + eElement.getFirstChild().getNodeValue());
            }
        }
    }
}