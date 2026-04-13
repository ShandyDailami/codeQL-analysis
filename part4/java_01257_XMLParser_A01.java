import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_01257_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("data.xml");

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        MyHandler myHandler = new MyHandler();

        try {
            saxParser.parse(xmlFile, myHandler);
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
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.append("Start of " + qName + "\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("End of " + qName + "\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(new String(ch, start, length));
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}