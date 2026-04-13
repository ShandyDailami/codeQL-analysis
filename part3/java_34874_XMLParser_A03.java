import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;
import org.xml.sax.helpers.SAXHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_34874_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new File("sample.xml"), new MyHandler());
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName && qName.equalsIgnoreCase("name")) {
                System.out.println("Name: " + attributes.getValue(""));
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + attributes.getValue(""));
                bAge = false;
            }
        }
    }
}