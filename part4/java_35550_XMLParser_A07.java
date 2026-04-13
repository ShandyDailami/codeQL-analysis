import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_35550_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Step 2: Retrieve the root element
            Element rootElement = doc.getDocumentElement();

            // Step 3: Retrieve and print the elements and values
            NodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    System.out.println("Element: " + element.getNodeName());
                    System.out.println("Value: " + element.getTextContent());
                }
            }

            // Step 4: Cleanup
            doc.detachNode(rootElement);
            dbFactory.getAdapters().asIterator().remove();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}