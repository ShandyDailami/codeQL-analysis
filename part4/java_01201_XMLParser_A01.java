import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01201_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse("data.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElement = false;
        String currElement = "";
        String currAttribute = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bElement = true;
            currElement = qName;
            if (attributes.getLength() > 0) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    currAttribute += attributes.getQName(i) + "=" + attributes.getValue(i) + " ";
                }
            }
            System.out.println("Start Element: " + currElement + ", Attributes: " + currAttribute);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bElement = false;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bElement) {
                System.out.println("Element content: " + new String(ch, start, length));
            }
        }
    }
}