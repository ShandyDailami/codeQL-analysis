import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_17618_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bAuthor;
        private boolean bTitle;
        private String tempValue;

        @Override
        public void startDocument() {
            bAuthor = bTitle = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("author")) {
                bAuthor = true;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("author")) {
                bAuthor = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bAuthor) {
                tempValue = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            if (bTitle) {
                System.out.println("Title: " + tempValue);
            }
            if (bAuthor) {
                System.out.println("Author: " + tempValue);
            }
        }
    }
}