import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_02510_XMLParser_A01 extends DefaultHandler {
    boolean bStartElement = false;
    String thisElement = "";
    
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        bStartElement = true;
        thisElement = qName;
    }
    
    public void endElement(String uri, String localName, String qName)
        throws SAXException {
        bStartElement = false;
        thisElement = "";
    }
    
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (bStartElement) {
            System.out.println(thisElement + ": " + new String(ch, start, length));
        }
    }
    
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(true);

            saxParser.parse(new File("sample.xml"), new MySAXHandler());

        } catch (ParsingException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}