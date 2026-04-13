import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXHandler;

public class java_04985_XMLParser_A08 {
    public static class MyHandler implements SAXHandler {
        private int count;
        private String element;

        public java_04985_XMLParser_A08(String element) {
            this.element = element;
            this.count = 0;
        }

        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals(element)) {
                count++;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            //nothing to do
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            //nothing to do
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        String xmlFile = "yourfile.xml";
        String element = "yourElement";

        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler(element);
            xr.setContentHandler(handler);
            xr.parse(xmlFile);

            System.out.println("Number of occurrences of \"" + element + "\": " + handler.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}