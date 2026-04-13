import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_17545_XMLParser_A08 extends DefaultHandler {

    private String lastTag = "";
    private boolean isAValidElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastTag = qName;

        // Check if the tag is valid. This is a simple check for the A08_IntegrityFailure.
        if(qName.equals("A08_IntegrityFailure")) {
            isAValidElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(lastTag.equals("A08_IntegrityFailure")) {
            // Do something with the characters here. This is a simple check for the A08_IntegrityFailure.
            System.out.println("A08_IntegrityFailure found: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("test.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}