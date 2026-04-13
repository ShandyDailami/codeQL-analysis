import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_17236_XMLParser_A01 {
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {
        // Load XML file
        File xmlFile = new File("path/to/your.xml");
        FileInputStream fis = new FileInputStream(xmlFile);

        // Create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the document
        Document doc = dBuilder.parse(fis);

        // Get the root element
        doc.getDocumentElement().normalize();

        // Print all the child elements of the root element
        printElement(doc.getDocumentElement());

        fis.close();
    }

    public static void printElement(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;

            // Print tag name and value
            System.out.println("Tag name: " + element.getTagName());

            // Get attributes
            Iterator<Attribute> attrs = element.getAttributes().iterator();
            while (attrs.hasNext()) {
                Attribute attr = attrs.next();
                System.out.println("Attribute: " + attr.getName() + "=" + attr.getValue());
            }

            // Get child nodes
            NodeList children = element.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printElement(children.item(i));
            }
        }
    }
}