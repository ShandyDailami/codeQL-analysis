import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLParserFactory;

import java.io.File;
import java.io.IOException;

public class java_41324_XMLParser_A07 {
    public static void main(String[] args) throws IOException, SAXException {
        File inputFile = new File("input.xml");
        XMLParserFactory factory = XMLParserFactory.newInstance();
        XMLParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(inputFile);
    }

    static class MyHandler extends DefaultHandler {
        private int depth = 0;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            depth++;
            printIndentation(depth);
            System.out.print("Start of element ");
            System.out.print(qName);
            System.out.println(" with " + attributes.getLength() + " attributes");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute " + (i + 1) + ": " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            depth--;
            printIndentation(depth);
            System.out.println("End of element " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (depth > 0) {
                printIndentation(depth);
                System.out.print("Characters: ");
                System.out.print(new String(ch, start, length));
            }
        }

        private void printIndentation(int depth) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
        }
    }
}