import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_05817_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(XMLParser.class.getClassLoader().getResourceAsStream("input.xml"));
            XMLHandler handler = new XMLHandler();
            parser.parse(new InputSource(new File("input.xml")), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    boolean bTitle = false;
    boolean bLink = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            bLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bTitle) {
            System.out.println("Title: " + qName);
            bTitle = false;
        } else if (bLink) {
            System.out.println("Link: " + qName);
            bLink = false;
        }
    }
}