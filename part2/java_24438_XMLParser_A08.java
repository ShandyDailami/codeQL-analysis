import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_24438_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("library.xml"), new SAXSource(new InputSource(new StringReader(""))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bookTitle = false;
        boolean bookAuthor = false;
        
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bookTitle = true;
            } else if (qName.equalsIgnoreCase("author")) {
                bookAuthor = true;
            }
        }
        
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bookTitle = false;
            } else if (qName.equalsIgnoreCase("author")) {
                bookAuthor = false;
            }
        }
        
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bookTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bookAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
            }
        }
    }
}