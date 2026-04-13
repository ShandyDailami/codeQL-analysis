import java.security.Permission;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27905_XMLParser_A08 implements Policy {
    public Permissions getPermissions(ProtectionDomain domain) {
        return new Permissions() {
            public boolean implies(Permission p) {
                return false;
            }
        };
    }
}

public class SimpleXMLParser {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setXIncludeSchemaResolver(null);
        factory.setXSI(false);
        SAXParser saxParser = factory.newSAXParser(null);

        saxParser.parse("src/main/resources/sample.xml", new SAXHandler());
    }
}

class SAXHandler extends DefaultHandler {
    private List<String> nodeNames;

    public java_27905_XMLParser_A08() {
        nodeNames = new ArrayList<>();
    }

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        nodeNames.add(qName);
        System.out.println("Start Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        if (content.trim().length() > 0) {
            System.out.println("Character data: " + content);
        }
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal error: " + error);
    }

    public void warning(SAXWarning warning) {
        System.out.println("Warning: " + warning.getMessage());
    }
}