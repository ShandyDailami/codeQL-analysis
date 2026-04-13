import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.io.File;

public class java_13368_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<root><element>Some data</element></root>"; // BrokenAccessControl
        parseXml(xml);
    }

    public static void parseXml(String xml) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser sp = spf.newSAXParser(new org.xml.sax.InputSource(new StringReader(xml)));

            MyHandler handler = new MyHandler();
            sp.setContentHandler(handler);

            sp.parse(new SAXSource(new StringReader(xml)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bElement;
    private StringBuilder sb;

    @Override
    public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
        bElement = true;
        sb = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            sb.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("element")) { // Security-sensitive operation
            System.out.println("Access to sensitive data is restricted: " + sb.toString());
        }
        bElement = false;
    }
}