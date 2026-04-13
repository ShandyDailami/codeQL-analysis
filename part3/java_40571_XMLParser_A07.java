import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_40571_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader parser = XMLReaderFactory.createXMLReader();

            AuthFailureHandler handler = new AuthFailureHandler();
            parser.setContentHandler(handler);
            parser.parse(inputFile);

            System.out.println("Authentication Failure: " + handler.isAuthFailure());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler implements org.xml.sax.ContentHandler {
    private boolean authFailure = false;

    @Override
    public void startDocument() {
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        if ("AuthFailure".equals(localName)) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    public boolean isAuthFailure() {
        return authFailure;
    }
}