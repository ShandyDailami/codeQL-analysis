import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.Transformers;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_22314_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(new File(xmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        printElement(doc.getDocumentElement(), 1);
    }

    private static void printElement(Element elem, int indentation) {
        System.out.print(getIndentation(indentation));
        System.out.println("Element: " + elem.getNodeName());
        if (elem.hasAttributes()) {
            System.out.print(getIndentation(indentation));
            System.out.println("Attributes: ");
            List<Attribute> attributes = new ArrayList<>();
            attributes.addAll(elem.getAttributes().asList());
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getName() + "=\"" + attribute.getValue() + "\"");
            }
        }
        NodeList childNodes = elem.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) childNode, indentation);
            }
        }
    }

    private static String getIndentation(int indentation) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}