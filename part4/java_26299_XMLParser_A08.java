import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26299_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {
        private String lastTag;
        private boolean bInTitle;

        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            lastTag = qName;
            bInTitle = false;
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            lastTag = null;
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (lastTag != null) {
                String content = new String(ch, start, length);
                if (bInTitle) {
                    System.out.println("Title: " + content);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, MyHandler.class);

        // Load the XML document
        String fileName = "src/main/resources/sample.xml";
        parser.parse(fileName, MyHandler.class);
    }
}