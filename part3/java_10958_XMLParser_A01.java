import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_10958_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Get a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("input.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all the child elements
            NodeList children = root.getChildNodes();

            // Loop through all the child elements
            for (int i = 0; i < children.getLength(); i++) {
                Element child = (Element) children.item(i);

                // Get the child element's attribute
                String attribute = child.getAttribute("secure");

                // Perform some operation (e.g., checking if the attribute is null or empty)
                if (attribute != null && !attribute.isEmpty()) {
                    System.out.println("Attribute found: " + attribute);
                }

                // Get the child element's text
                String text = child.getTextContent();

                // Perform some operation (e.g., checking if the text is null or empty)
                if (text != null && !text.isEmpty()) {
                    System.out.println("Text found: " + text);
                }
            }
        } catch (ParserConfigurationException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}