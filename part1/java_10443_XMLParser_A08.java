import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_10443_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a SecurityManager that allows executing of all actions
        SecurityManager sm = new SecurityManager() {
            public void checkPermission(Permission perm) {
                if (perm.getName().contains("file:")) {
                    throw new SecurityException("Permission denied");
                }
            }
        };

        // Set the security manager
        System.setSecurityManager(sm);

        // Try parsing the XML file
        try (FileInputStream fis = new FileInputStream("example.xml")) {
            javax.xml.parsers.SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSecurityManager(sm);
            javax.xml.parsers.SAXParser sp = spf.newSAXParser();
            XmlHandler xh = new XmlHandler();
            sp.parse(fis, xh);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

class XmlHandler extends DefaultHandler {
    private boolean parsingFailed = false;

    public void startDocument() {
        // Do nothing
    }

    public void endDocument() {
        // Do nothing
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Do nothing
    }

    public void endElement(String uri, String localName, String qName) {
        // Do nothing
    }

    public void characters(char[] ch, int start, int length) {
        // Do nothing
    }

    public void fatalError(String error) {
        parsingFailed = true;
        System.out.println("Fatal error: " + error);
    }

    public boolean getParsingFailed() {
        return parsingFailed;
    }
}