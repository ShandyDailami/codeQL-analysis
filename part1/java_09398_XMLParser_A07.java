import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_09398_XMLParser_A07 {
    public static void main(String[] args) {
        String url = "https://www.example.com/file.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }

                public void fatalError(SAXParseException e) {
                    System.out.println("Fatal Error: " + e.getMessage());
                }

                public void warning(SAXParseException e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            });

            XMLReader xr = parser.getXMLReader();
            xr.setFeature("http://xml.org/sax/features/namespaces", true);
            xr.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            xr.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xr.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            xr.parse(url, new SAXSource(xr));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}