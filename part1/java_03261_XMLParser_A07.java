import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_03261_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bId = false;
    private boolean bPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("user")) {
            bName = true;
            bId = true;
            bPassword = true;
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("id")) {
            bId = true;
        } else if (qName.equals("password")) {
            bPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("user")) {
            bName = false;
            bId = false;
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName) {
            // Do something with name
        } else if(bId) {
            // Do something with id
        } else if(bPassword) {
            // Do something with password
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            AuthFailureHandler authFailureHandler = new AuthFailureHandler();
            saxParser.parse(inputFile, authFailureHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}