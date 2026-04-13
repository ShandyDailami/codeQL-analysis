import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_34356_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Parse XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Step 2: Get root element
            Element root = doc.getDocumentElement();

            // Step 3: Iterate over all child nodes
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node node = children.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element name: " + element.getNodeName());
                }
            }
        } catch (ParserConfigurationException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}