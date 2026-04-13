import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_22467_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Create a DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file and create a Document object
            Document doc = builder.parse(new File("example.xml"));

            // Step 4: Create a new instance of a unique class
            XmlParserImpl parser = new XmlParserImpl();

            // Step 5: Use the parser's method to process the Document object
            processDocument(doc, parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processDocument(Document doc, XmlParserImpl parser) {
        // Extract and print all the element names
        Iterator iterator = doc.getElementsByTagName("*").item(0).getChildNodes().item(0).getChildNodes().item(0).getNodeName();
        while (iterator.hasNext()) {
            System.out.println(iterator.nextNode());
        }

        // Add your security sensitive operations here, such as accessing private fields or methods

        // Call the parser's method to handle the document
        parser.parseDocument(doc);
    }
}

class XmlParserImpl {
    public void parseDocument(Document doc) {
        // Implement your security sensitive operations here
    }
}