import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupport;

public class java_23308_XMLParser_A03 {

    private static class MyHandler extends DefaultHandlerSupport {

        private boolean bName = false;
        private boolean bAge = false;

        public void startElement(String uri, String localName, String qName,
                org.xml.sax.Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                return;
            }

            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(new MyHandler());
        xr.parse("people.xml"); // replace with your XML file
    }
}