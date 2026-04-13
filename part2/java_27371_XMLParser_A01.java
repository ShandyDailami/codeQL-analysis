// Start of code

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27371_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for the Document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Handle the document here
            handleDocument(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleDocument(Document doc) {
        // This method is for security-sensitive operations
        // It should not be used to break access control
    }
}

// End of code