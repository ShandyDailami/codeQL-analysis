import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_40913_XMLParser_A01 {
    private static final String XML_FILE_PATH = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);
        XMLParserHandler handler = new XMLParserHandler();

        try {
            XMLParser parser = new SAXParser(handler);
            XMLLoader loader = new XMLLoader(parser, 1024);
            loader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class XMLParserHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAuthor;
        private boolean bGenre;
        private String currentTag;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of the document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of the document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = qName;

            if (qName.equals("book")) {
                bName = true;
                bAuthor = true;
                bGenre = true;
            } else {
                switch (qName) {
                    case "name":
                        bName = true;
                        break;
                    case "author":
                        bAuthor = true;
                        break;
                    case "genre":
                        bGenre = true;
                        break;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentTag = "";

            if (qName.equals("book")) {
                bName = false;
                bAuthor = false;
                bGenre = false;
            } else {
                switch (qName) {
                    case "name":
                        bName = false;
                        break;
                    case "author":
                        bAuthor = false;
                        break;
                    case "genre":
                        bGenre = false;
                        break;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Book Name: ");
                System.out.println(new String(ch, start, length));
            } else if (bAuthor) {
                System.out.print("Book Author: ");
                System.out.println(new String(ch, start, length));
            } else if (bGenre) {
                System.out.print("Book Genre: ");
                System.out.println(new String(ch, start, length));
            }
        }
    }
}