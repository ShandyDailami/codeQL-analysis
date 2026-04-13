import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06268_XMLParser_A01 extends DefaultHandler {

    private boolean bAccessControl;
    private String currentElement;

    public void startDocument() throws SAXException {
        bAccessControl = false;
        currentElement = null;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("access")) {
            bAccessControl = true;
            currentElement = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("access")) {
            bAccessControl = false;
            currentElement = null;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAccessControl && currentElement != null && currentElement.equals("access")) {
            String access = new String(ch, start, length);
            // Do something with access control information here
            // For example, print access control information
            System.out.println("Access Control Info: " + access);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            saxParser.parse(new File("broken-access-control.xml"), new BrokenAccessControlParser());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}