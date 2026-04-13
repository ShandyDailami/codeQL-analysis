import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_19716_XMLParser_A07 {

    public static void main(String[] args) {

        // Step 1: Create a DocumentBuilderFactory and a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Parse the XML file
        Document document = null;
        try {
            document = builder.parse(new File("sample.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Step 3: Create an XPathFactory and an XPath
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // Step 4: Use XPath to select nodes from the document
        String expression = "/root/name";
        Object result = xpath.evaluate(expression, document, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;

        // Step 5: Process the selected nodes
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Node " + (i+1) + ": " + node.getNodeValue());
        }
    }
}