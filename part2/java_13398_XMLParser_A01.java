import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_13398_XMLParser_A01 {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("sample.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(xmlFile, MyHandler.myValidation);
    }

    static class MyHandler extends DefaultHandler {

        boolean bAccessControl = false;
        boolean bSecurity = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("accessControl")) {
                bAccessControl = true;
                System.out.println("Access Control: " + qName);
            } else if (qName.equalsIgnoreCase("security")) {
                bSecurity = true;
                System.out.println("Security: " + qName);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("accessControl")) {
                bAccessControl = false;
            } else if (qName.equalsIgnoreCase("security")) {
                bSecurity = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAccessControl) {
                System.out.println("Access Control: " + new String(ch, start, length));
            } else if (bSecurity) {
                System.out.println("Security: " + new String(ch, start, length));
            }
        }
    }
}