import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_10058_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML from the file
            Document doc = builder.parse(new File("input.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get the first child element
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) children.item(i);
                    System.out.println("Child element: " + element.getNodeName());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}