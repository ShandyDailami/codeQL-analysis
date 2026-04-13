import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_22492_XMLParser_A01 {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser saxParser = spf.newSAXParser();
                    XMLHandler xh = new XMLHandler();
                    saxParser.parse(new FileInputStream("example.xml"), xh);
                } catch (AccessControlException ace) {
                    LOGGER.log(Level.SEVERE, "Access to file denied", ace);
                } catch (IOException ioe) {
                    LOGGER.log(Level.SEVERE, "File read failed", ioe);
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Error parsing XML", e);
                }
                return null;
            }
        });
    }
}