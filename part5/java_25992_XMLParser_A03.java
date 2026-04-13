import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25992_XMLParser_A03 {

    public static void main(String[] args) {

        // Step 1: Parse XML file
        try {
            // Step 1.1: Create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 1.2: Use the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 1.3: Parse the XML document
            Document document = builder.parse(getInputStream("resources/example.xml"));

            // Step 1.4: Process the document
            processDocument(document);

        } catch (ParserConfigurationException | SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(String fileName) {
        return new FileInputStream(fileName);
    }

    private static void processDocument(Document document) {
        // Implement the logic to process the document
    }
}