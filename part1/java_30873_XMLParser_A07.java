import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30873_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<note><to>Tove</to><from>Jani</from><message>Vanilla XML SAX</message></note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bto = false;
        boolean bfrom = false;
        boolean bmsg = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("to")) {
                bto = true;
            } else if (qName.equals("from")) {
                bfrom = true;
            } else if (qName.equals("message")) {
                bmsg = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("to")) {
                bto = false;
            } else if (qName.equals("from")) {
                bfrom = false;
            } else if (qName.equals("message")) {
                bmsg = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bto) {
                System.out.println("To: " + new String(ch, start, length));
                bto = false;
            } else if (bfrom) {
                System.out.println("From: " + new String(ch, start, length));
                bfrom = false;
            } else if (bmsg) {
                System.out.println("Message: " + new String(ch, start, length));
                bmsg = false;
            }
        }
    }
}