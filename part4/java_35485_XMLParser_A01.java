import java.io.File;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35485_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    parseXML("src/test.xml");
                    return null;
                }
            });
        } catch (AccessControlException e) {
            System.out.println("Unable to access resource");
        }
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Using access controller to ensure the access is secured
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new empty document
        Document doc = builder.newDocument();

        try {
            // Read the file into the document
            doc.load(new File(fileName));

            // Now, you can use doc as needed
            System.out.println("Document loaded successfully");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}