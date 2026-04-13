import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28442_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new SAXHandler());
            saxParser.parse(new File("src/main/resources/sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private StringBuilder buffer;

    @Override
    public void startDocument() {
        buffer = new StringBuilder();
    }

    @Override
    public void endDocument() {
        System.out.println(buffer.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.append("Start of ").append(qName).append(" \n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        buffer.append("End of ").append(qName).append("\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(new String(ch, start, length));
    }

    @Override
    public void error(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void fatalError(SAXException e) {
        e.printStackTrace();
    }

    @Override
    public void warning(SAXException e) {
        e.printStackTrace();
    }
}