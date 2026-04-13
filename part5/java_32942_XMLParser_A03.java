import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_32942_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDoctype();

            Element root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            printElement(root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());

        // Print attributes
        Iterator<?> itr = element.getAttributes().iterator();
        while (itr.hasNext()) {
            ? attr = (Attribute) itr.next();
            System.out.println("Attribute name: " + attr.getName());
            // Print attribute values
            System.out.println("Attribute value: " + attr.getValue());
        }

        // Print child nodes
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Element childElement = (Element) children.item(i);
            printElement(childElement);
        }
    }
}