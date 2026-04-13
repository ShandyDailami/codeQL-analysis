import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_28674_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a new instance of the XMLReader
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;

        try {
            saxParser = factory.newSAXParser(new InputSource(new File("input.xml")));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return;
        }

        // Create a new instance of the DefaultHandler
        MyHandler myHandler = new MyHandler();
        saxParser.parse(new InputSource(new File("input.xml")), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start element: " + qName);

        // Security sensitive operation
        String password = attributes.getValue("password");
        if (password != null && password.equals("secret")) {
            System.out.println("Password matches!");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}