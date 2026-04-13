import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_20652_XMLParser_A07 {
    public static void main(String[] args) {
        String file = "authfailure.xml";

        try {
            SAXParser parser = SAXParser.newInstance();
            SAXHandler handler = new SAXHandler();
            parser.setContentHandler(handler);
            parser.parse(new File(file));

            List<String> errors = handler.getErrors();
            for (String error : errors) {
                System.out.println(error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParser extends XMLParser {
    SAXParser() {
        super(new SAXHandler());
    }
}

class SAXHandler extends DefaultHandler {
    private List<String> errors = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Here you can implement your security sensitive operations
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Here you can implement your security sensitive operations
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Here you can implement your security sensitive operations
    }

    @Override
    public void error(SAXException e) {
        errors.add("AuthFailure: " + e.getMessage());
    }

    public List<String> getErrors() {
        return errors;
    }
}