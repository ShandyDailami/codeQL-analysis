import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19796_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse("sample.xml", new MyHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bTag = false;
        private String currentValue = null;

        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            bTag = true;
            currentValue = "";
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            bTag = false;
            printElement(qName, currentValue);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                currentValue = new String(ch, start, length);
            }
        }

        private void printElement(String elementName, String elementValue) {
            System.out.println("Element Name: " + elementName);
            System.out.println("Element Value: " + elementValue);
        }
    }
}