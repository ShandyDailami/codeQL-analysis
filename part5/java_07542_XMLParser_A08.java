import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07542_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<doc>\n" +
                "<item>Item 1</item>\n" +
                "<item>Item 2</item>\n" +
                "<item>Item 3</item>\n" +
                "</doc>";

        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new StringReader(xml), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bItem = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                bItem = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                bItem = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bItem) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}