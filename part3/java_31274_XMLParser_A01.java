import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31274_XMLParser_A01 {
    public static void main(String[] args) {
        AccessControl acc = new AccessControl() {
            @Override
            public <T> T doPrivileged(PrivilegedAction<T> action) throws Exception {
                return action.run();
            }
        };

        AccessControlContext accContext = new AccessControlContext(acc);

        try {
            // Use access control context to get a privileged action.
            PrivilegedAction<Document> docAction = new PrivilegedAction<Document>() {
                public Document run() {
                    try {
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        // Use access control context to get a document.
                        return dBuilder.parse(new FileInputStream(
                                AccessController.doPrivileged(new PrivilegedAction<InputStream>() {
                                    public InputStream run() {
                                        return new FileInputStream("broken-access-control-document.xml");
                                    }
                                }, accContext)));
                    } catch (ParserConfigurationException | SAXException | java.io.IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            };

            Document doc = AccessController.doPrivileged(docAction, accContext);

            // Continue with the parsed document...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}