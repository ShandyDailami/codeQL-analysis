import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_25210_XMLParser_A01 {

    // SAX parsing with custom handler
    private static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new org.xml.sax.InputSource(new File(fileName)));
            saxParser.setEntityResolver(new MyEntityResolver());
            saxParser.parse(new MyHandler(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAX handler
    static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String str = new String(ch, start, length);
            System.out.println("Character data: " + str);
        }
    }

    // Entity resolver to prevent loading of external DTDs/XDRs
    static class MyEntityResolver extends DTDResolver {
        @Override
        public InputSource resolveEntity(String publicId, String systemId) {
            return new InputSource(new StringReader(""));
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
    }
}