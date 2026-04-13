import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_31054_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new DTDHandler(null));

            saxParser.parse(new File("sample.xml"), new DTDHandler(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class DTDHandler extends DefaultHandler {
        public java_31054_XMLParser_A07(String arg0) {
            super(arg0);
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String arg0, String arg1, Attributes arg2)
                throws SAXException {
            System.out.println("Start Element: " + arg1);
        }

        @Override
        public void endElement(String arg0, String arg1, Attributes arg2)
                throws SAXException {
            System.out.println("End Element: " + arg1);
        }

        @Override
        public void characters(char[] arg0, int arg1, int arg2)
                throws SAXException {
            System.out.println("Characters: " + new String(arg0, arg1, arg2));
        }

        @Override
        public void fatalError(SAXException arg0) throws SAXException {
            System.out.println("Fatal Error: " + arg0.getMessage());
        }

        @Override
        public void warning(SAXException arg0) throws SAXException {
            System.out.println("Warning: " + arg0.getMessage());
        }
    }
}