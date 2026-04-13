import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_29251_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // path to your xml file
        parseXML(xmlFile);
    }

    private static void parseXML(String xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = dBuilder.parse(new File(xmlFile));
            doc.getDocumentElement().normalize();

            // create an instance of the Injection class
            Injection injection = new Injection(doc);

            // start parsing the XML
            parseNode(doc.getDocumentElement());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseNode(Node node) {
        if (node instanceof Element) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode instanceof Element) {
                    parseNode(childNode);
                }
            }
        }
    }

    // Injection class is a placeholder for security sensitive operations
    static class Injection {
        Document doc;

        Injection(Document doc) {
            this.doc = doc;
        }

        public void doSomething() {
            // do something with the document
        }
    }
}