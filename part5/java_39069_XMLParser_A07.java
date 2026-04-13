import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class java_39069_XMLParser_A07 {
    public static void main(String[] args) {
        String inputFile = "input.xml";
        parseXML(inputFile);
    }

    public static void parseXML(String inputFile) {
        try {
            InputStream inputStream = new FileInputStream(new File(inputFile));
            XMLParser handler = new SAXHandler(inputStream);
            XMLParser.parse(handler, new InputSource(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        private InputStream inputStream;

        public java_39069_XMLParser_A07(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}