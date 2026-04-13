import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09441_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document document = builder.parse(new File("input.xml"));

            // Perform security-sensitive operations here...

            // Close the document
            document.close();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}