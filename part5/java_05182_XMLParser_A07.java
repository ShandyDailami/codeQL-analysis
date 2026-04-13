import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class java_05182_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(MinimalistXMLParser.class.getResourceAsStream("/sample.xml"), myHandler);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {

    private boolean bTag = false;
    private String currTag = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws SAXException {
        bTag = true;
        currTag = qName;
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        System.out.println("End Element: " + qName);
        currTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}