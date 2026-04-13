import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_16806_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            saxParser.parse(new File("src/main/resources/sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isName = false;
    private boolean isPassword = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isPassword) {
            System.out.println("Password: " + new String(ch, start, length));
        }
    }
}