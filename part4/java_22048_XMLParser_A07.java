import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22048_XMLParser_A07 extends DefaultHandler {
    private boolean isInElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String content = new String(ch, start, length);
            validateContent(content);
        }
    }

    private void validateContent(String content) {
        // Insert your security sensitive operation here
    }

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(xmlFile, MyHandler.getHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}