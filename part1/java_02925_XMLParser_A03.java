import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_02925_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the document
            Document doc = builder.parse(new File("test.xml"));
            doc.getDocumentElement().normalize();

            // print all element names and attributes
            printElementsAndAttributes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                Iterator<Attr> attrIterator = element.getAttributes().iterator();
                while (attrIterator.hasNext()) {
                    Attr attr = attrIterator.next();
                    System.out.println("Attribute: " + attr.getName() + " = " + attr.getValue());
                }
            }
        }
    }
}