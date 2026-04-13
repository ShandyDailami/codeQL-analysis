import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_14015_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");

        XMLParserHandler handler = new XMLParserHandler();

        try {
            XMLParser parser = XMLLoader.forUnmarshalling(handler, xmlFile);
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class XMLParserHandler extends DefaultHandler {
        private boolean isName;
        private boolean isAuthor;
        private boolean isYear;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                isName = true;
                isAuthor = false;
                isYear = false;
            } else if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("author")) {
                isAuthor = true;
            } else if (qName.equals("year")) {
                isYear = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                isName = false;
                isAuthor = false;
                isYear = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (isAuthor) {
                System.out.println("Author: " + new String(ch, start, length));
                isAuthor = false;
            } else if (isYear) {
                System.out.println("Year: " + new String(ch, start, length));
                isYear = false;
            }
        }
    }
}