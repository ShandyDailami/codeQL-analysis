import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30199_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        XMLReaderFactory.newInstance().createXMLReader(XMLReader.SAX_FEATURE_NAMESPACES).setFeature("http://xml.org/sax/features/namespaces", true);
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + localName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + localName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start prefix mapping: " + prefix + ", URI: " + uri);
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End prefix mapping: " + prefix);
            }
        };
        XMLReader reader = XMLReaderFactory.newInstance().createXMLReader();
        reader.setFeature("http://xml.org/sax/features/namespaces", true);
        reader.setContentHandler(handler);
        reader.parse(new InputSource(new StringReader(xml)));
    }
}