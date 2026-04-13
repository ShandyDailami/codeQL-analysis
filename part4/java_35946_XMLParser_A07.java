import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class java_35946_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load XML data from a URL
            URL url = new URL("https://www.w3schools.com/java/xml_intro.asp");
            Document doc = builder.parseURL(url.toString());

            // Create an XPathFactory and an XPath
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            // Use XPath to select specific nodes
            XPathExpression expr = xpath.compile("//child::*[name()='xml']/child::*[name()='tag']");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            // Perform security-sensitive operations
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                // Perform security-sensitive operation
                // ...
            }

            // Print out the results
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getTagName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}