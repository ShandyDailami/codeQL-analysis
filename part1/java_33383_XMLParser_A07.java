import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_33383_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseXMLFile(xmlFile);
    }

    static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(fileName));
            doc.getDoctype();
        } catch (Exception e) {
            System.out.println("Parse error: " + e.getMessage());
            return;
        }

        doc.getDocumentElement().normalize();
        printElement(doc.getDocumentElement(), 0);
    }

    static void printElement(Element elem, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println(elem.getNodeName());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printElement((Element) child, indent);
            } else if (child.getNodeType() == Node.TEXT_NODE && ((Text) child).getNodeValue().trim().length() > 0) {
                for (int j = 0; j < indent; j++) {
                    System.out.print("  ");
                }

                System.out.println(((Text) child).getNodeValue().trim());
            }
        }
    }
}