import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;

import java.io.File;
import java.io.IOException;

public class java_29147_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new MyHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }
    }
}

class MyHandler extends DefaultHandler {
    private String lastElement;
    private String lastValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        lastValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(lastElement)) {
            System.out.println("End element: " + qName + ", Value: " + lastValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        lastValue = new String(ch, start, length);
    }
}