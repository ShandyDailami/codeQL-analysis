import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35350_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory and use it to create a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Print out the XML document's content
            printDocument(doc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Use DOM (Document Object Model) to access and manipulate the content of the XML document
        System.out.println("XML file content:");
        System.out.println(doc.getDocumentElement().getNodeName());
        // Print each child node
        System.out.println(doc.getChildNodes().getLength());
    }
}