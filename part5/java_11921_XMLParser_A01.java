import java.io.File;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11921_XMLParser_A01 {

    private static final Logger logger = Logger.getLogger(BrokenAccessControlXMLParser.class.getName());

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // PrivilegedAction to get the file
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    File file = new File("path_to_your_file");
                    Document doc = builder.parse(file);
                    return null;
                }
            });
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in parsing XML file", e);
        }
    }
}