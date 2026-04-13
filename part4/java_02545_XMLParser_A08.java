import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_02545_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file
            Document doc = builder.parse(new File("input.xml"));

            // TODO: Add your code here to process the document. For instance, print the document's
            // nodes and attributes.

            // Print the document nodes and attributes
            doc.getElementsByTagName("node").item(0).getFirstChild().getNodeValue());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}