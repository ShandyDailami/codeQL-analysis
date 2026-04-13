import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_12436_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        try {
            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            
            printElement(doc.getDocumentElement());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void printElement(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            System.out.println("Element Name : " + element.getNodeName());
            printAttributes(element);
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printElement(childNodes.item(i));
            }
        }
    }
    
    public static void printAttributes(Element element) {
        System.out.println("Attributes : ");
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            System.out.println("Attribute Name : " + element.getAttributes().item(i).getNodeName() + " = " + element.getAttributes().item(i).getTextContent());
        }
    }
}