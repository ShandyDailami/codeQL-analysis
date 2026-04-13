import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32954_XMLParser_A01 {

    // DefaultHandler is a class that implements the SAX content handler
    public static class ContentHandler extends DefaultHandler {
        private String lastElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElement = qName;
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastElement = null;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement != null) {
                String elementValue = new String(ch, start, length);
                System.out.println("Element Value: " + elementValue);
            }
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(null, new ContentHandler());

            String xmlFilePath = "resources/sample.xml"; // replace with your xml file path
            saxParser.parse(xmlFilePath, ContentHandler.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}