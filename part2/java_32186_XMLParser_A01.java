import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32186_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File file = new File("yourfile.xml"); // replace with your XML file
            parser.parse(file, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean isTitle = false;
        private boolean isLink = false;
        private boolean isPubDate = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = true;
            } else if (qName.equalsIgnoreCase("pubDate")) {
                isPubDate = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                isLink = false;
            } else if (qName.equalsIgnoreCase("pubDate")) {
                isPubDate = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (isLink) {
                System.out.println("Link: " + new String(ch, start, length));
            } else if (isPubDate) {
                System.out.println("Publication Date: " + new String(ch, start, length));
            }
        }
    }
}