import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_37672_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("example.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("Start element: " + qName);
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                System.out.println("Start element: " + qName);
            } else if (bAge && qName.equals("age")) {
                System.out.println("Start element: " + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("End element: " + qName);
                bName = false;
                bAge = false;
            } else if (bName && qName.equals("name")) {
                System.out.println("End element: " + qName);
            } else if (bAge && qName.equals("age")) {
                System.out.println("End element: " + qName);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName || bAge) {
                String s = new String(ch, start, length);
                System.out.println("Character data: " + s);
                if (bName) bName = false;
                if (bAge) bAge = false;
            }
        }
    }
}