import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Stack;

public class java_28013_XMLParser_A07 {
    private static Stack<String> elementStack = new Stack<>();

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = XMLReader.newSAXParser(new File("example.xml"));
        parser.setContentHandler(new MyContentHandler());
    }

    private static class MyContentHandler extends DefaultHandler {
        private static final String TAG_START = "<[^>]+>";
        private static final String TAG_END = "</[^>]+>";
        private static final String TAG_NAME = "</?([^>]+)>";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            elementStack.push(qName);
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementStack.pop();
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!elementStack.isEmpty()) {
                System.out.print("Character data in element: ");
                for (int i = start; i < start + length; i++) {
                    System.out.print(ch[i]);
                }
                System.out.println();
            }
        }
    }
}