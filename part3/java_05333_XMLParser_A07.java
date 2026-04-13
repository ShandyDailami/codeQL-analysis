import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_05333_XMLParser_A07 {

    private DefaultHandler handler;
    private XMLReader reader;

    public java_05333_XMLParser_A07() throws SAXException {
        handler = new DefaultHandler();
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
    }

    public void parse(String fileName) throws IOException, SAXException {
        reader.parse(new File(fileName));
    }

    private class MyContentHandler extends DefaultHandler {
        private boolean isElement = false;
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                org.xml.sax.Attributes attributes) throws SAXException {
            isElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                                throws SAXException {
            isElement = false;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                                throws SAXException {
            if (isElement) {
                System.out.println("Element: " + currentElement + ", Content: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        new XmlParser().parse("src/main/resources/sample.xml");
    }
}