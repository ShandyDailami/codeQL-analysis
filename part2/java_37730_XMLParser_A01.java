import java.io.File;
import java.io.FileInputStream;
import java.security.AccessController;
import java.security.Access;

public class java_37730_XMLParser_A01 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            File file = new File("sample.xml");
            fis = new FileInputStream(file);
            parse(fis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void parse(FileInputStream fis) {
        try {
            java.util.Vector v = javax.xml.parsers.SAXParserFactory.newInstance().newSAXParser().parse(fis, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends javax.xml.parsers.SAXHandler {
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
            System.out.println("Start Element: " + localName);
            AccessController.doPrivileged(new GetAccessAction(attributes));
        }

        public void endElement(String uri, String localName, String qName)
                throws javax.xml.parsers.SAXException {
            System.out.println("End Element: " + localName);
        }

        public void characters(char[] ch, int start, int length)
                throws javax.xml.parsers.SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    private static class GetAccessAction implements java.security.PrivilegedAction {
        private javax.xml.parsers.Attributes attributes;

        public java_37730_XMLParser_A01(javax.xml.parsers.Attributes attributes) {
            this.attributes = attributes;
        }

        public Object run() {
            // No access control for attribute printing.
            attributes.getLength();
            return null;
        }
    }
}