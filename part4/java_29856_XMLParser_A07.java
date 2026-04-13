import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_29856_XMLParser_A07 {
    private SecurityManager sm = new SecurityManager() {
        public void checkElement(String element) {
            throw new SecurityException("Attempt to access security-sensitive operation");
        }
    };

    public void parse(final String xml) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
                    dbf.setFeature("http://xml.org/sax/features/external-parametrization", false);
                    dbf.setFeature("http://xml.org/sax/features/namespaces", false);
                    dbf.setFeature("http://xml.org/sax/features/nonvalidating/load-dtd", false);

                    javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
                    javax.xml.parsers.SAXParser saxp = db.newSAXParser(null);

                    MyHandler mh = new MyHandler();
                    saxp.setProperty("http://xml.org/sax/properties/external-generalized-element", Boolean.FALSE);
                    saxp.parse(xml, mh);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public static void main(String[] args) {
        XMLParser xp = new XMLParser();
        xp.parse("<root><element>content</element></root>");
    }
}

class MyHandler extends javax.xml.parsers.SAXHandler {
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}