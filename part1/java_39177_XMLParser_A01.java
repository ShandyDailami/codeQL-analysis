import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39177_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equals("name")) {
                bName = false;
            } else if (bName && qName.equals("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName && bAge) {
                System.out.println("Name: " + new String(ch, start, length));
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(Class.forName("org.xml.sax.InputSource").getMethod("of", String.class).invoke(null, "src/test.xml"), handler);
    }
}