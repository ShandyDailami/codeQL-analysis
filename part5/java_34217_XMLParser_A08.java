import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_34217_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = builder.parse("src/main/resources/sample.xml");

            // Get the root element
            Element root = doc.getDocumentElement();

            // Print the node names and the text contained in each node
            printElement(root);
            printElement(root.getChildNodes());

            // Create a new instance of the TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Create a new Transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Set the result to a DOMSource
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // Set the result to a StreamResult
            StreamResult result = new StreamResult("src/main/resources/sample-indented.xml");

            // Use a transformer to write the modified document to the result file
            transformer.transform(source, result);
        } catch (ParsingException | TransformerException | SAXException | DOMException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(NodeList nodeList) {
        Stream.of(nodeList).forEach(XmlParser::printElement);
    }

    private static void printElement(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Name: " + element.getNodeName());
            System.out.println("Value: " + element.getFirstChild().getNodeValue());
            printElement(element.getChildNodes());
        }
    }
}