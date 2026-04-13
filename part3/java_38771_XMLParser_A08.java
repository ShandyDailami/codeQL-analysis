import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_38771_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MyHandler handler = new MyHandler();
        try {
            parser.parse(new File("input.xml"), handler);
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bStart;
    boolean bEnd;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
        bStart = true;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
        bEnd = true;
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start element: " + qName);
        bStart = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        bEnd = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bStart) {
            System.out.println("Text: " + new String(ch, start, length));
            bStart = false;
        }
    }
}