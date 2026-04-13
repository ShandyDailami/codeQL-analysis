import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.SAXSourceCompatible;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_30001_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = spf.newSAXParser();
            MyHandler myHandler = new MyHandler();
            SAXSource saxSource = new SAXSourceCompatible(new MyContentHandler(myHandler), true);
            XMLReader xr = saxParser.getXMLReader();
            xr.setContentHandler(myHandler);
            xr.parse(saxSource, myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler extends DefaultHandler {
    MyHandler handler;

    MyContentHandler(MyHandler handler) {
        this.handler = handler;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        handler.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        handler.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        handler.characters(ch, start, length);
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private String name = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equals("name")) {
            bName = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (localName.equals("name")) {
            bName = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
        }
    }

    public void fatalError(String error) throws SAXException {
        throw new SAXException(error);
    }

    public void warning(SAXWarning warning) throws SAXException {
        throw new SAXException(warning.getMessage());
    }
}