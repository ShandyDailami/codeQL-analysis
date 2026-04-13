import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_25540_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            parse("src/main/resources/example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(String file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new StreamSource(new String(
                org.apache.commons.io.IOUtils.toString(new java.io.File(file))));

        printDocument(doc);

        // Secure operations related to A03_Injection
        //...
    }

    private static void printDocument(Document doc) {
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printNode(nodes.getNode(i));
        }
    }

    private static void printNode(org.w3c.dom.Node node) {
        System.out.println("Node: " + node.getNodeName());
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printNode(childNodes.getNode(i));
            }
        }
    }

}