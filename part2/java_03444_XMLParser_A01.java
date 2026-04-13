import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03444_XMLParser_A01 {

    public static void main(String[] args) {
        // UseAccessControl method to invoke PrivilegedAction
        // to access some elements of SecurityManager
        try {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    System.out.println("Accessing SecurityManager elements...");
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(new File("sample.xml"));
                    // Here we are performing a security-sensitive operation
                    // that involves accessing SecurityManager
                    System.out.println("Security-sensitive operation completed.");
                    return null;
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }
}