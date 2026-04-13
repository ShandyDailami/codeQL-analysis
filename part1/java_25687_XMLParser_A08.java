import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25687_XMLParser_A08 {
    private DefaultHandler handler;
    private XMLReader reader;

    public java_25687_XMLParser_A08(String fileName) throws IOException {
        this.handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start prefix mapping: " + prefix + "=" + uri);
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End prefix mapping: " + prefix);
            }
        };

        this.reader = XMLReaderFactory.createXMLReader();
        this.reader.setContentHandler(handler);
        this.reader.setEntityResolver(new CustomEntityResolver());
    }

    public void parse() throws IOException, SAXException {
        System.out.println("Parsing...");
        this.reader.parse(new File(this.getClass().getClassLoader().getResource("test.xml").toURI()));
    }

    public static void main(String[] args) throws IOException, SAXException {
        new MinimalistXMLParser("test.xml").parse();
    }
}