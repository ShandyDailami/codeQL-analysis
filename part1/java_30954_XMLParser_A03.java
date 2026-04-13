import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class java_30954_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Create an XPath expression to select the elements
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//element/@attribute");

            // Select the elements
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            // Print out the names and values of the selected elements
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String attributeValue = element.getAttribute("attribute");
                System.out.println("Attribute: " + attributeValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}