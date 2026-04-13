import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_34584_XMLParser_A01 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private boolean bTag = false;
    private String currentTag = "";

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bTag = false;
        currentTag = qName;
        data.setLength(0);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            data.append(new String(ch, start, length));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTag.equalsIgnoreCase("person")) {
            System.out.println(data);
        }
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Not implemented
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        // Not implemented
    }
}

public class XMLParser {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}