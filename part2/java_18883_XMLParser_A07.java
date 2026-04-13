import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18883_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        private List<String> names = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            names.add(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            names.add(localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            names.add(new String(ch, start, length));
        }

        public List<String> getNames() {
            return names;
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();

        URL url = new URL("http://example.com/auth.xml");
        parser.parse(url.openStream(), handler);

        List<String> names = handler.getNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}