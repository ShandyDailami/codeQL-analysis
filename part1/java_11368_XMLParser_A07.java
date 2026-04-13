import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_11368_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFilePath = "example.xml";
        parseXML(xmlFilePath);
    }

    private static void parseXML(String xmlFilePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(xmlFilePath)));
            XMLHandler handler = new XMLHandler();
            parser.setContentHandler(handler);
            parser.parse(new File(xmlFilePath));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean isElementName = false;
    private String elementName = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isElementName = true;
        elementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElementName) {
            System.out.println(elementName);
            isElementName = false;
        }
    }
}