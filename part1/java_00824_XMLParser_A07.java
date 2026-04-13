import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_00824_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXSource saxSource = null;

        try {
            saxSource = new SAASource(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(new CustomContentHandler());

        try {
            xmlReader.parse(saxSource);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class SAASource extends SAXSource {
        public java_00824_XMLParser_A07(File file) throws IOException {
            super(file);
        }
    }

    static class CustomContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}