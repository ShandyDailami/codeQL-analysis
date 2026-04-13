import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_38973_XMLParser_A07 {
    public static void main(String[] args) {
        String inputFile = "legacy_style.xml";
        parseXMLFile(inputFile);
    }

    private static void parseXMLFile(String inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new FileInputStream(inputFile));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        printNode(doc, doc.getDocumentElement(), 1);

        String authFailureElementName = "AuthFailure";
        NodeList nodeList = doc.getElementsByTagName(authFailureElementName);
        System.out.println("Number of " + authFailureElementName + " elements: " + nodeList.getLength());

        Iterator<?> iterator = nodeList.iterator();

        while (iterator.hasNext()) {
            Node nextNode = (Node) iterator.next();
            System.out.println("Text content of node: " + nextNode.getTextContent());
        }
    }

    private static void printNode(Document doc, org.w3c.dom.Node node, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println("Element: " + node.getNodeName());

        if (node.hasChildNodes()) {
            for (Iterator i = node.childNodes().iterator(); i.hasNext();) {
                org.w3c.dom.Node nextNode = (org.w3c.dom.Node) i.next();
                printNode(doc, nextNode, indent + 1);
            }
        }
    }
}