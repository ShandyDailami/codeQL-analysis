import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.apache.xerces.jaxp.validation.DOMValidatableSource;
import org.xml.sax.SAXException;

public class java_28863_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the XML file
            Document doc = builder.parse(getFileAsInputStream("sample.xml"));

            // Print out the parsed information
            printDocumentInfo(doc);

        } catch (Exception e) {
            System.out.println("Parsing failed: " + e.getMessage());
        }
    }

    private static InputStream getFileAsInputStream(String fileName) {
        ClassLoader classLoader = XMLParser.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        return inputStream;
    }

    private static void printDocumentInfo(Document doc) {
        System.out.println("Document title: " + doc.getDocumentElement().getTagName());
        System.out.println("Document has " + doc.getChildNodes().getLength() + " child nodes");
    }
}