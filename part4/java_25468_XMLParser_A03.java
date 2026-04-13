import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25468_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private boolean bCountry;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("country")) {
            bCountry = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (bName) {
            System.out.print("Name: ");
            bName = false;
        } else if (bAge) {
            System.out.print("Age: ");
            bAge = false;
        } else if (bCountry) {
            System.out.print("Country: ");
            bCountry = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
            bName = false;
        } else if (bAge) {
            System.out.println(new String(ch, start, length));
            bAge = false;
        } else if (bCountry) {
            System.out.println(new String(ch, start, length));
            bCountry = false;
        }
    }
}