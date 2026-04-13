import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_08452_XMLParser_A07 {
    public static class XMLHandler extends DefaultHandler {
        private boolean name = false;
        private boolean author = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                this.name = true;
            } else if (qName.equalsIgnoreCase("author")) {
                this.author = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (this.name) {
                System.out.println("Book name: " + new String(ch, start, length));
                this.name = false;
            } else if (this.author) {
                System.out.println("Book author: " + new String(ch, start, length));
                this.author = false;
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        File xmlFile = new File("books.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        XMLHandler xmlHandler = new XMLHandler();
        saxParser.parse(xmlFile, xmlHandler);
    }
}