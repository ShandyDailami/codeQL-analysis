import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_37040_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create an instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get the DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new SourceResource("injection.xml"));

            // Step 4: Use the DOM (Document Object Model) to extract data
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "/bookstore/book";
            NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            // Step 5: Print out the extracted data
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Book " + (i+1) + ": " + node.getChildNodes().item(0).getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}