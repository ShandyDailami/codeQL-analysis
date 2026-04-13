import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_06353_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the input file into a Document
            Document doc = builder.parse(new File("example.xml"));

            // get the root element of the Document
            Element root = doc.getDocumentElement();

            // get all the child nodes of the root element
            NodeList list = root.getChildNodes();

            // iterate over the child nodes
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                // print the node name and its content
                System.out.println("Node: " + node.getNodeName() + ", Content: " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}