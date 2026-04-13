import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import java.io.File;
import java.io.IOException;

public class java_38098_XMLParser_A03 extends DefaultHandler {
    private static final String XML_FILE = "example.xml";
    private static final String PREFIX = "A03";

    public static void main(String[] args) {
        try {
            SAXHelper saxHelper = new SAXHelper();
            saxHelper.setDefaultHandler(new XmlSaxParser());
            saxHelper.parse(new File(XML_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.startsWith(PREFIX)) {
            System.out.println("Found element: " + qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.startsWith(PREFIX)) {
            System.out.println("Ended element: " + qName);
        }
    }
}