import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_00763_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            XMLParser parser = new SAXParser();
            parser.parse("src/input.xml", new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bTag = false;
        StringBuffer sbf = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            bTag = true;
            sbf.setLength(0);
            sbf.append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bTag) {
                sbf.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bTag = false;
            // Handle the XML element here
            System.out.println("End Element: " + sbf.toString());
        }
    }
}