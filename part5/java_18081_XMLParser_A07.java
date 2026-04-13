import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

public class java_18081_XMLParser_A07 {

    private DefaultHandler handler;
    private SAXParser parser;

    public java_18081_XMLParser_A07() {
        handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Character content: " + content);
            }
        };

        try {
            parser = org.xml.sax.SAXParserFactory.newInstance().newSAXParser(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parse(String filePath) {
        try {
            parser.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MinimalistXMLParser parser = new MinimalistXMLParser();
        parser.parse("sample.xml");
    }
}