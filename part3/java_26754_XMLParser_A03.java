import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_26754_XMLParser_A03 {

    public static void main(String[] args) {

        BasicHandler handler = new BasicHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}