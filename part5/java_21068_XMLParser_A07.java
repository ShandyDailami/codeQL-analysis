import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_21068_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<root><item>Data1</item><item>Data2</item></root>";

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new StringReader(xml), handler);

            System.out.println(handler.getItems());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content = new StringBuilder();
        private List<String> items = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            content.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                items.add(content.toString());
            }
        }

        public List<String> getItems() {
            return items;
        }
    }
}