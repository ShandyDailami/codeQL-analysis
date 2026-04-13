import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.InputSource;
import java.io.File;
import java.io.IOException;

public class java_37624_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // sample XML file
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        try {
            File xmlSource = new File(xmlFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlSource);
            doc.getDocumentElement().normalize();

            XPath xpath = XPath.newInstance();
            String expression = "/bookstore/book";  // XPath query to select all 'book' elements
            NodeList nodes = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            System.out.println("Number of 'book' elements: " + nodes.getLength());

            // Print out the attributes of each 'book' element
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Book " + (i + 1) + ":");
                System.out.println("Title: " + node.getAttributes().getNamedItem("title").getNodeValue());
                System.out.println("Author: " + node.getAttributes().getNamedItem("author").getNodeValue());
                System.out.println("Price: " + node.getAttributes().getNamedItem("price").getNodeValue());
                System.out.println("-----------------");
            }

        } catch (IOException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}