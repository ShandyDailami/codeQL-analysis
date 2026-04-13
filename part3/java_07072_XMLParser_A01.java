import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_07072_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("books.xml"), new MyHandler());

        } catch (SAXParseException e) {
            System.out.println("Parse error at line " + e.getLineNumber());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private String lastTag = "";
        private String lastTagContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            lastTag = qName;
            lastTagContent = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            lastTag = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastTagContent += new String(ch, start, length);
        }

        @Override
        public void endDocument() {
            System.out.println("Last tag: " + lastTag);
            System.out.println("Last tag content: " + lastTagContent);
        }
    }
}