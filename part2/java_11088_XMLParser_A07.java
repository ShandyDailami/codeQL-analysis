import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_11088_XMLParser_A07 extends DefaultHandler {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        try {
            parser.parse(new File("input.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isAuthFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("AuthFailure".equals(qName)) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("AuthFailure".equals(qName)) {
            isAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailure) {
            System.out.println(new String(ch, start, length));
        }
    }
}