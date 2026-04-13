import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.event.Handler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.event.StartElement;
import org.xml.sax.event.ElementHandler;
import org.xml.sax.event.EndElement;
import org.xml.sax.event.Attribute;

public class java_28708_XMLParser_A08 {
    public static void main(String[] args) {
        Handler handler = new DefaultHandler();
        XMLReader reader = XMLReaderFactory.createXMLReader();

        ElementHandler elementHandler = new ElementHandler() {
            public void startElement(StartElement start) throws SAXException {
                System.out.print("Start element: " + start.getLocalName());
            }

            public void endElement(EndElement end) throws SAXException {
                System.out.println("End element: " + end.getLocalName());
            }

            public void characters(char[] chars, int start, int length) throws SAXException {
                String content = new String(chars, start, length);
                System.out.print("Content: " + content);
            }
        };

        reader.setContentHandler(elementHandler);
        try {
            reader.parse("test.xml", new SAXSource(new InputSource(new StringReader("test xml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}