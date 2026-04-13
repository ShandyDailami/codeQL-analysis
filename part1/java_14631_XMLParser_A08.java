import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14631_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastElementName)) {
                System.out.println("End element: " + qName);
            } else {
                System.out.println("Start of " + qName);
            }
            lastElementName = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElementName != null && lastElementName.equals(qName)) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content.trim());
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}