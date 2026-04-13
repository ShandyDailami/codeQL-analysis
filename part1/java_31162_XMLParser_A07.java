import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_31162_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser(true);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        XMLHandler handler = new XMLHandler();
        try {
            parser.parse(new File("sample.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private boolean isAuthFailed = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("AuthFailure".equals(localName)) {
            isAuthFailure = true;
        }
        if ("AuthFailed".equals(localName)) {
            isAuthFailed = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isAuthFailure && isAuthFailed) {
            // Handle security sensitive operation
            System.out.println("Security sensitive operation related to AuthFailure has been performed.");
        }
        isAuthFailed = false;
        isAuthFailure = false;
    }
}