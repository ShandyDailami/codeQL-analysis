import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_12354_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(XmlSaxParser.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAttribute = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
            currentElement = qName;
            bName = true;
            bAttribute = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
            bName = false;
            bAttribute = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Element: " + currentElement);
            }
            if (bAttribute) {
                String attr = new String(ch, start, length);
                System.out.println("Attribute: " + attr);
            }
        }
    }
}