import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_02432_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            SAXHandler sh = new SAXHandler();
            XMLReader xr = sp.getXMLReader();
            xr.setContentHandler(sh);
            xr.parse("example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bElement = false;
        String elementValue = "";
        String elementName = "";

        @Override
        public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
            bElement = true;
            elementName = localName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                elementValue = new String(ch, start, length);
                bElement = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            System.out.println(elementName + " : " + elementValue);
            elementName = "";
            elementValue = "";
        }

    }
}