import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_38813_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Get all the element nodes
            NodeList nodeList = document.getElementsByTagName("element");

            // Process each element
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    // Process each element
                    String elementName = element.getTagName();
                    String elementValue = element.getTextContent();
                    System.out.println("Element name: " + elementName);
                    System.out.println("Element value: " + elementValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}