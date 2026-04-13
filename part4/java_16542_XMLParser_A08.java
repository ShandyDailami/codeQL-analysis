import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16542_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        private boolean integrityFailure = false;

        public boolean getIntegrityFailure() {
            return integrityFailure;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("element")) {
                integrityFailure = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        parser.parse(A08_IntegrityFailure.class.getResourceAsStream("/sample.xml"), true);

        MyHandler handler = (MyHandler) parser.getListener();
        if (handler.getIntegrityFailure()) {
            System.out.println("Integrity failure detected!");
        } else {
            System.out.println("No integrity failure detected.");
        }
    }
}