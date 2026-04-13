import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14965_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;

            if (qName.equals("employee")) {
                bName = true;
                bAge = true;
            } else {
                System.out.println("Start Element: " + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("employee")) {
                bName = false;
                bAge = false;
           
            } else if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            } else {
                System.out.println("End Element: " + qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        MyHandler mh = new MyHandler();

        try {
            sp.parse(new File("sample.xml"), mh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}