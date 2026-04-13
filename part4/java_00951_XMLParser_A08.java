import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00951_XMLParser_A08 {

    public static void main(String[] args) {
        // Create the DocumentBuilderFactory and instantiate it
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Set the security manager
        factory.setValidating(true);
        factory.setErrorHandler(new SecurityErrorHandler());

        // Get the DocumentBuilder from the factory
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file and store it in a Document object
            Document doc = builder.parse(new File("secure_file.xml"));

            // Now you can use the parsed document as per your requirements

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define your own SecurityErrorHandler
    private static class SecurityErrorHandler extends ErrorHandler {

        @Override
        public void fatalError(SAXException e) throws SAXException {
            // This method is called if an error occurs
            // In this case, we will just ignore the error
            System.out.println("Fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXException e) throws SAXException {
            // This method is called if a warning occurs
            // In this case, we will just ignore the warning
            System.out.println("Warning: " + e.getMessage());
        }
    }
}