import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import org.xml.sax.exters.DefaultHandler;

public class java_40794_XMLParser_A08 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Toussaint</to>\n" +
                "<from>Laurent</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}