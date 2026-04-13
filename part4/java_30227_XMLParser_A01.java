import java.security.Permission;
import java.security.SecurityManager;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class java_30227_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // create a SecurityManager
            SecurityManager sm = new SecurityManager() {
                public void checkPermission(Permission perm) {
                    if (perm.getName().equals("getAcess")) {
                        throw new SecurityException("Access to XML file denied");
                    }
                }
            };
            System.setSecurityManager(sm);

            // create a Logger
            Logger logger = Logger.getLogger("myLogger");
            logger.addHandler(new Handler() {
                public void publish(java.util.Event evt) {
                    System.out.println("Logging: " + evt);
                }
                public void close() {}
                public void flush() {}
            });

            // create a DOM parser
            javax.xml.parsers.DocumentBuilderFactory dbFactory =
                    javax.xml.parsers.DocumentBuilderFactory.newInstance();
            dbFactory.setValidating(true); // enable validation
            javax.xml.parsers.DocumentBuilder db = dbFactory.newDocumentBuilder();

            // parse the XML file
            db.setFeature("http://xml.org/sax/features/namespaces", true);
            db.setFeature("http://xml.org/sax/features/namespaces", false);
            db.setFeature("http://xml.org/sax/features/external-general-entities", false);
            db.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            javax.xml.parsers.SAXParserFactory spFactory = SAXParserFactory.newInstance();
            spFactory.setValidating(false); // disable validation
            SAXParser saxParser = spFactory.newSAXParser(new DefaultHandler());
            saxParser.parse(Main.class.getResourceAsStream("/invalid.xml"), new XMLHandler());

        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}

class XMLHandler extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}