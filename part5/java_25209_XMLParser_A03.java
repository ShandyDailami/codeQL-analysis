import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25209_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new XMLHandler());
            saxParser.parse(new File("path_to_your_xml_file.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        private StringBuilder sb = new StringBuilder();
        private boolean elementName = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            elementName = true;
            sb.setLength(0);
            sb.append(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (elementName) {
                sb.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            elementName = false;
            System.out.println(sb.toString());
        }
    }
}