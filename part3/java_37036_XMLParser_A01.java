import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLEventHandler;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_37036_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new XMLReader(new MyHandler()));
            saxParser.parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);

        System.out.print("Start element: ");
        System.out.println(qName);

        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        elementStack.pop();

        System.out.print("End element: ");
        System.out.println(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();

        if (!content.isEmpty()) {
            System.out.print("Element content: ");
            System.out.println(content);
        }
    }

    private void printAttributes(Attributes attributes) {
        if (attributes == null) {
            return;
        }

        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print("Attribute: ");
            System.out.println(attributes.getQName(i) + "=" + attributes.getValue(i));
        }
    }
}