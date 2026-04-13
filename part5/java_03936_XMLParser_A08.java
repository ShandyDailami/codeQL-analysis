import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_03936_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new MyContentHandler());
            xr.parse("sample.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        boolean isInElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isInElement = true;
            System.out.println("Start element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                System.out.println("Character data: " + new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isInElement = false;
            System.out.println("End element: " + qName);
        }
    }
}