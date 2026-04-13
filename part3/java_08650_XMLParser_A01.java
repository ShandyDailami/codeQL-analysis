import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_08650_XMLParser_A01 {

    public static void main(String[] args) {

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file and store in a Document object
            Document doc = builder.parse(new File("input.xml"));

            // Get all the elements in the document
            NodeList nList = doc.getElementsByTagName("*");

            // Print all elements and attributes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getTagName());

                    // Print all attributes of the element
                    NodeList attrList = element.getAttributes();
                    for (int j = 0; j < attrList.getLength(); j++) {
                        Node attr = attrList.item(j);
                        System.out.println("Attribute: " + attr.getNodeName() + "=" + attr.getTextContent());
                   
                    }

                }
            }

            // Closing the Document
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}