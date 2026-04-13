import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_19321_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";
        XMLReader xr = SAXParser.newInstance().getSAXParser().getSAXParser().getXMLReader();

        // Ensure SAX parser is thread safe
        xr.setFeature("http://xml.apache.org/xalan/security/thread-safety", "http://xml.apache.org/SAX_NS_2.0/thread-safety-yes");

        xr.setContentHandler(new MyContentHandler());
        xr.parse("data.xml", new SAXSource(new StringReader(xml)));
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}