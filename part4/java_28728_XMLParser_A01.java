import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Security;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28728_XMLParser_A01 {
    public static void main(String[] args) {
        // Enable security manager
        Security.addProvider(new SecurityProvider());

        try {
            // Create SAXParser factory
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            // Create SAXParser
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Create InputStream
            InputStream inputStream = new FileInputStream("sample.xml");

            // Parse XML
            saxParser.parse(inputStream, new XMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// XMLHandler
class XMLHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
            javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws javax.xml.parsers.SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}

// SecurityProvider
class SecurityProvider extends SecurityManager {
    @Override
    public void checkAccess(String file) throws SecurityException {
        // Check access rules here. You can add code here to check if the file
        // has been modified by a user. If it has, throw a SecurityException.
        // For example:
        // if (file.getLastModified() > System.currentTimeMillis() -
        // 30*1000) {
        // throw new SecurityException("File has been modified");
        // }
    }
}