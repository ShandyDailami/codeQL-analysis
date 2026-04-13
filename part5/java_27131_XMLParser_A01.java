import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.Access;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27131_XMLParser_A01 {

    private static final String FILE_PATH = "sample.xml"; // replace with your file path

    public static void main(String[] args) {

        // Set up security manager
        AccessController.doPrivileged(new PrivilegedAction<Access>() {
            public Access find(String name) {
                return new SecurityManager().find(getClass().getClassLoader(), name);
            }
        });

        try {
            // Parse XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(FILE_PATH));

            // Print parsed XML
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}