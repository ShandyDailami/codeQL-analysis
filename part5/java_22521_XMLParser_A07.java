import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLEventReader;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_22521_XMLParser_A07 {

    private static Stack<String> elementStack = new Stack<>();
    private static DefaultHandler handler = new DefaultHandler() {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            elementStack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            elementStack.pop();
        }
    };

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = XMLParser.newInstance();
        parser.setContentHandler(handler);
        parser.parse(new File("sample.xml"));
    }
}