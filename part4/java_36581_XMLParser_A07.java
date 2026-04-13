import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36581_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            // Security sensitive operation related to AuthFailure
            System.out.println(new String(ch, start, length));
        }
    }
}

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyXMLHandler myXMLHandler = new MyXMLHandler();
            saxParser.parse(Main.class.getResourceAsStream("/path/to/your/file.xml"), myXMLHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}