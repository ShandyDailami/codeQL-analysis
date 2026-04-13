import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_14255_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            SAXHandler saxHandler = new SAXHandler();

            saxParser.parse(xmlFile, saxHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCity = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (bCity) {
            System.out.println("City: " + new String(ch, start, length));
        }
    }
}