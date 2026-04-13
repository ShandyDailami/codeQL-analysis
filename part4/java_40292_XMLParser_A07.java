import java.io.*;
import java.security.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_40292_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(new XMLReader(null));

            LegacyXMLHandler handler = new LegacyXMLHandler();
            sp.parse("sample.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LegacyXMLHandler implements SAXHandler {
    private boolean isAuthFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = false;
        }
    }

    @Override
    public boolean startDocument() throws SAXException {
        return true;
    }

    @Override
    public boolean endDocument() throws SAXException {
        return true;
    }

    public boolean isAuthFailure() {
        return isAuthFailure;
    }
}