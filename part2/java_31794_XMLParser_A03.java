import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_31794_XMLParser_A03 {

    public static void main(String[] args) {

        // Step 1: Create DocumentBuilderFactory and Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            // Step 2: Parse the XML file
            doc = builder.parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 3: Create an XPathFactory and XPath
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // Step 4: Use XPath to find nodes
        try {
            // Inject code here
            String expression = "//book[price > '30']";
            XPathExpression expr = xpath.compile(expression);
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Book " + (i + 1) + ":");
                System.out.println("Title: " + nodes.item(i).getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}