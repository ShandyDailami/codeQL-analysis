import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40393_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new File("sample.xml"), Handler.MODE_FIRST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {
        boolean bEntry = false;
        boolean bTitle = false;
        boolean bContent = false;
        String currentData = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("entry")) {
                bEntry = true;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("content")) {
                bContent = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("entry")) {
                bEntry = false;
            } else if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("content")) {
                bContent = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bEntry) {
                currentData += new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Entry: " + currentData);
        }
    }
}