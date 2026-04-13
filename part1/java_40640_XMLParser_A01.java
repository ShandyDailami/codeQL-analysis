import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControl;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_40640_XMLParser_A01 {

    public static void main(String[] args) {
        runParser("src/main/resources/sample.xml", new AccessControl() {
            @Override
            public <T> T doPrivileged(PrivilegedAction<T> action) throws Exception {
                return action.execute();
            }
        });
    }

    private static void runParser(String fileName, AccessControl accessControl) {
        accessControl.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(new FileInputStream(fileName));
                    // Parse and process the XML document
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}