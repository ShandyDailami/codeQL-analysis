import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_05163_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
            public void startElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}