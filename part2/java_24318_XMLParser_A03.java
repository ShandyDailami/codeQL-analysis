import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.io.File;
import java.io.IOException;

public class java_24318_XMLParser_A03 {
    private DefaultHandler handler;
    private SAXHelper sax;

    public java_24318_XMLParser_A03() {
        handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of XML Document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of XML Document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                System.out.println("Start of Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                String content = new String(ch, start, length);
                System.out.println("Character Content: " + content);
            }
        };
        sax = new SAXHelper();
    }

    public void parse(String fileName) throws IOException, SAXException {
        sax.setContentHandler(handler);
        sax.parse(new File(fileName));
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
    }
}