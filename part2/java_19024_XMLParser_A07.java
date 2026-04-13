import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_19024_XMLParser_A07 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    public java_19024_XMLParser_A07() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MySAXParser());
            parser.parse(new File("input.xml"), this);
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementStack.push(qName);
        System.out.println(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        elementStack.pop();
        System.out.println(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println("  " + content);
        }
    }

    public static void main(String[] args) throws IOException {
        new XMLParser();
    }
}

class MySAXParser extends DefaultHandler {
    @Override
    public void error(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void warning(SAXWarning e) {
        e.printStackTrace();
    }
}