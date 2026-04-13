import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_30500_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new DefaultHandler());

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(filePath));
            saxParser.parse(inputStream, new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class SAXHandler extends DefaultHandler {

        private boolean bTitle = false;
        private boolean bLink = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bLink) {
                System.out.println("Link: " + new String(ch, start, length));
            }
        }
    }
}