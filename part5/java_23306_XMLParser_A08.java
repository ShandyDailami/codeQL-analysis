import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_23306_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml")); // replace with your xml file

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print all element names
            printElementNames(root);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Element element) {
        System.out.println("Element name: " + element.getNodeName());

        // Get all child elements
        List<Element> children = element.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            printElementNames((Element) children.get(i));
        }
    }
}