import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_30203_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse("src/main/resources/injection.xml", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private StringBuilder content;
    private boolean isInCommand;

    @Override
    public void startDocument() throws SAXException {
        content = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        String input = content.toString();
        // Security-sensitive operation: command injection
        // In real-world applications, avoid directly executing user-provided commands
        // Instead, sanitize the input and execute it as necessary
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInCommand = qName.equals("command");
        content.append(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        content.append(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInCommand) {
            // Security-sensitive operation: command injection
            // In real-world applications, avoid directly executing user-provided commands
            // Instead, sanitize the input and execute it as necessary
        } else {
            content.append(new String(ch, start, length));
        }
    }
}