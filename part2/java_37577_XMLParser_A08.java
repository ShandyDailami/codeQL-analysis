import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handlers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_37577_XMLParser_A08 {

    public static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String xmlFile = "example.xml";

        File inputFile = new File(xmlFile);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}