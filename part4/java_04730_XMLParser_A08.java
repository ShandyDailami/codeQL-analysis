import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04730_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // Wrapper True -> SAX Parser is non-thread-safe.

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/test.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for XML parsing
    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private StringBuffer s = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            s.setLength(0);
            bTag = true;
            s.append("<").append(qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bTag) {
                s.append("/>");
                System.out.println(s.toString());
                bTag = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                s.append(new String(ch, start, length));
            }
        }

        private void printAttributes(Attributes attributes) {
            if (attributes != null && attributes.getLength() > 0) {
                s.append(" ");
                for (int i = 0; i < attributes.getLength(); i++) {
                    s.append(attributes.getQName(i)).append("='").append(attributes.getValue(i)).append("'");
                    if (i < attributes.getLength() - 1) {
                        s.append(",");
                    }
                }
            }
        }
    }
}