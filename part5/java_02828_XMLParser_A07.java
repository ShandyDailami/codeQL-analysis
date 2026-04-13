import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02828_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/legacyStyle.xml", myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bTag = false;
    String thisValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bTag = true;
        thisValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            thisValue += new String(ch, start, length);
        }
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