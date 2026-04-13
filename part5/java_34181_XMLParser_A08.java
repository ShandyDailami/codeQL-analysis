import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class java_34181_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml"); // replace with your XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = "/bookstore/book"; // replace with your XPath expression
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Book " + (i + 1));
                System.out.println("Title: " + element.getAttribute("title"));
                System.out.println("Price: " + element.getAttribute("price"));
                System.out.println("Author: " + element.getAttribute("author"));
                System.out.println("-----------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}