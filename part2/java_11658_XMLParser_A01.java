import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_11658_XMLParser_A01 {

    private static final String XmlFile = "yourXmlFile.xml";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(new InputStreamReader(getInputStream(XmlFile)));
            MyHandler myHandler = new MyHandler();
            saxParser.parse(myHandler, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("name")) {
                bName = true;
            }
            if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (bName) {
                System.out.println("Name: " + new String(chars, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(chars, start, length));
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }
    }
}