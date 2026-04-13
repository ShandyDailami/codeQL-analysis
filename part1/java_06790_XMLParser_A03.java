import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06790_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                return;
            }

            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (bName) {
                String s = new String(chars, start, length);
                System.out.println("Name: " + s);
                bName = false;
            } else if (bAge) {
                String s = new String(chars, start, length);
                System.out.println("Age: " + s);
                bAge = false;
            }
        }

    }

    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);
        MyHandler mh = new MyHandler();

        sp.parse(new File("src/people.xml"), mh);
    }

}