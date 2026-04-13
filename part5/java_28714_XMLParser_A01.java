import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.AccessDeniedException;
import java.security.PrivilegedAction;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28714_XMLParser_A01 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        String file = "example.xml";

        // Use a privileged action to check the access control
        PrivilegedAction<?> action = new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    // Read the file with standard libraries
                    InputStream in = new FileInputStream(file);
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(in);
                    // Do something with the document
                    logger.info("File accessed successfully.");
                    return null;
                } catch (FileNotFoundException e) {
                    logger.severe("File not found.");
                    return null;
                } catch (AccessDeniedException e) {
                    logger.severe("Access to the file denied.");
                    return null;
                } catch (SAXException e) {
                    logger.severe("Error parsing the XML file.");
                    return null;
                }
            }
        };

        // Execute the action with access control
        AccessController.doPrivileged(action);
    }
}