import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_02458_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder builder;
    private boolean bTag;
    private String currentTag;

    @Override
    public void startDocument() throws SAXException {
        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        builder.setLength(0);
        bTag = false;
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            builder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTag.equalsIgnoreCase("person")) {
            System.out.println(builder.toString());
        } else {
            bTag = true;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("WARNING: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("ERROR: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("FATAL ERROR: " + e.getMessage());
    }
}