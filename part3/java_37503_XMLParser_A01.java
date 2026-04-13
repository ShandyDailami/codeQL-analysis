import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37503_XMLParser_A01 {
    private static class MyHandler extends DefaultHandler {
        private boolean bAccessControl = false;
        private StringBuilder bAccessControlContent;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("access_control")) {
                bAccessControl = true;
                bAccessControlContent = new StringBuilder();
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAccessControl) {
                bAccessControlContent.append(new String(ch, start, length));
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("access_control")) {
                String content = bAccessControlContent.toString();
                // Here you would handle the content of access_control element.
                // For example, you could check if it contains a known broken access control string.
                if (content.contains("broken_access_control")) {
                    System.out.println("Access control found in XML document: " + content);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.setContentHandler(new MyHandler());
            saxParser.parse(new File("sample.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}