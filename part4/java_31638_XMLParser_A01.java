import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_31638_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Ignore the tags
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!elementStack.isEmpty()) {
            System.out.println(elementStack.peek() + "> " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            XMLParser parser = XMLReader.newSAXParser(new File("example.xml"), new MyHandler());
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}