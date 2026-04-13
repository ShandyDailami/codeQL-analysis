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

public class java_24311_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    // Step 1: Get access to a document
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(new File("sample.xml"));

                    // Step 2: Attempt to read the document without access control
                    try {
                        doc.getElementsByTagName("tag"); // This should not cause an exception

                        // Step 3: Provide access to the document
                        // Insecure way: Reading the document directly
                        doc.getElementsByTagName("tag").item(0).getChildNodes().item(0).getNodeValue();

                        // Secure way: Reading the document with access control
                        // Note: This should fail because the document is not well-formed
                        doc.getElementsByTagName("tag").item(0).getFirstChild().getNextSibling().getNodeValue();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            });
        } catch (AccessControlException | PrivilegedActionException e) {
            e.printStackTrace();
        }
    }
}