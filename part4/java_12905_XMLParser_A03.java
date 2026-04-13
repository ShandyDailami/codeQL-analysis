import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_12905_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {

        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element: " + localName);
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

    }

    public static void main(String[] args) {
        File xmlFile = new File("test.xml");
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}