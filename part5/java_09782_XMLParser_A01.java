import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_09782_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new SourceResource("example.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all the child elements
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Get the attributes
                    String attributeValue = element.getAttribute("attributeName");
                    // Get the text inside the element
                    String elementValue = element.getFirstChild().getNodeValue();
                    System.out.println("Attribute Value: " + attributeValue);
                    System.out.println("Element Value: " + elementValue);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}