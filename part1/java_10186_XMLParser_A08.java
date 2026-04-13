import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;

public class java_10186_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<document><message>Hello, World!</message></document>";
        parseXML(xml);
    }

    public static void parseXML(String xml) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser(true);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start of element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}