import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Permission;
import java.security.SecurityManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29681_XMLParser_A08 {

    // Create a SecurityManager that allows access to our XML file
    private SecurityManager sm = new SecurityManager() {
        public void checkPermission(Permission perm) {
            // do nothing - we allow all permissions
        }

        public void checkActions(String actions) {
            // do nothing - we only care about file access
        }
    };

    public Document readXMLFile(String fileName) throws IOException {
        // Use DocumentBuilderFactory to get a DocumentBuilder
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Use SecurityManager to ensure we have permission to access the file
        sm.checkPermission(new java.io.FilePermission(fileName));
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);

        // Use DocumentBuilder to parse the XML file
        Document document = dBuilder.parse(fis);

        fis.close();

        return document;
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        try {
            Document document = parser.readXMLFile("sample.xml");
            // Continue with your parsing logic here...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}