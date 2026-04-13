import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14389_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Access control for PrivilegedAction
            PrivilegedAction<?> action = new PrivilegedAction<Void>() {
                @Override
                public Void run() {
                    throw new AccessControlException("Unsupported Operation: BrokenAccessControl");
                }
            };
            // Access control check
            AccessController.doPrivileged(action);

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the document
            Document doc = builder.parse(new File("example.xml"));

            // Your code here

        } catch (AccessControlException e) {
            System.out.println("Access to security-sensitive operations is denied: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Failed to parse configuration: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Failed to parse XML: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Exception: " + e.getMessage());
        }
    }
}