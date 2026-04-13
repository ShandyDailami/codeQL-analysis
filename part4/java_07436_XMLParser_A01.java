import java.io.File;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_07436_XMLParser_A01 {
    private Stack<String> stack = new Stack<>();

    public void parse(String fileName) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
            reader.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ContentHandlerImpl extends DefaultHandler {
        @Override
        public void startDocument() throws SAXParseException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXParseException {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stack.push(qName);
            printIndentation();
            System.out.println(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            printIndentation();
            System.out.println(qName);
        }

        private void printIndentation() {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print("  ");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            for (int i = start; i < start + length; i++) {
                System.out.print(ch[i]);
            }
        }
    }
}