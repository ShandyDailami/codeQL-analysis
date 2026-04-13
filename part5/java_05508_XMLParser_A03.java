import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControlException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05508_XMLParser_A03 {

    public static void main(String[] args) {
        // Step 1: Set up the XML parser.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation for security-sensitive operations.

        // Step 2: Create a DocumentBuilder to parse the XML document.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Load the XML file and create a Document object.
        Document document;
        try (FileInputStream fis = new FileInputStream("sample.xml")) {
            document = builder.parse(fis);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error loading or parsing the XML file: " + e.getMessage());
            return;
        }

        // Step 4: Process the XML document.
        // For example, print all element names and values.
        document.getElementsByTagName("*").item(0).getNodeName();
    }
}