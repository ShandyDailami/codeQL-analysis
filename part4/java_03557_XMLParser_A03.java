import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_03557_XMLParser_A03 {

    private Stack<String> stack = new Stack<>();

    public void parse(String file) throws IOException, SAXException {
        XMLParser parser = XMLParser.newInstance();
        parser.setContentHandler(new MyContentHandler());
        parser.parse(new File(file));
    }

    private class MyContentHandler extends DefaultHandler {

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
            stack.push(qName);
            printIndent();
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            printIndent();
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents = new String(ch, start, length);
            if(contents.trim().length() > 0) {
                printIndent();
                System.out.println("Characters: " + contents);
            }
        }

        private void printIndent() {
            for(int i = 0; i < stack.size(); i++) {
                System.out.print("--");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLSAXParser parser = new XMLSAXParser();
        parser.parse("sample.xml");
    }
}