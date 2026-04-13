import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_17262_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(url, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean item = false;
        boolean title = false;
        boolean body = false;
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                item = true;
            } else if (qName.equalsIgnoreCase("title")) {
                title = true;
            } else if (qName.equalsIgnoreCase("body")) {
                body = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                item = false;
            } else if (qName.equalsIgnoreCase("title")) {
                title = false;
            } else if (qName.equalsIgnoreCase("body")) {
                body = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (item) {
                System.out.println("Item: " + new String(ch, start, length));
            } else if (title) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (body) {
                System.out.println("Body: " + new String(ch, start, length));
            }
        }
    }
}