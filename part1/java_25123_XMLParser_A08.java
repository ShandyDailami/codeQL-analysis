import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_25123_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new instance of the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element of the document
            Element root = doc.getDocumentElement();

            // Print the namespace URI and the local name of the root element
            System.out.println("Namespace URI: " + root.getNamespaceURI());
            System.out.println("Root element: " + root.getLocalName());

            // Print the names of all elements in the document
            for (int i = 0; i < root.getChildNodes().getLength(); i++) {
                Node node = root.getChildNodes().item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getLocalName());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}