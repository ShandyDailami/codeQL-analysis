import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16904_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }
            if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: ");
                bName = false;
            }
            if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: ");
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse("src/person.xml", new MyHandler());
    }
}