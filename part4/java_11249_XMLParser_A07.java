import java.io.File;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;
import java.security.SecurityStatus;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11249_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");

        // Create a SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Set the policy to allow all security operations
        spf.setValidate(true);
        spf.setNamespaceAware(true);
        spf.setXincludeAware(true);

        // Set the policy
        Policy policy = spf.getPolicy();
        policy.setAction(SecurityPermission.class.getName(), "exit");

        try {
            // Create a new SAXParser
            SAXParser saxp = spf.newSAXParser();
            // Create a new DefaultHandler
            DefaultHandler dh = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            // Parse the XML file
            saxp.parse(xmlFile, dh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}