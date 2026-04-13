import java.io.File;
import java.io.FileInputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04942_XMLParser_A01 {
    private static final String FILE_PATH = "broken.xml";

    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    File file = new File(FILE_PATH);
                    FileInputStream fis = new FileInputStream(file);

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(fis);

                    // Your code to handle the document goes here.
                    // This code may access the file with broken access control.

                    return null;
                } catch (Exception e) {
                    throw new AccessControlException("Access to file denied: " + e.getMessage());
                }
            }
        });
    }
}