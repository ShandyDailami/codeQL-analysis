import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.xmlreader.XMLReader;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class java_09797_XMLParser_A03 {
    private static final List<String> SENSITIVE_TAGS = Arrays.asList("password", "secret", "key");

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // replace with your xml file path
        SAXParser(xmlFilePath);
    }

    private static void SAXParser(String xmlFilePath) {
        XMLParser parser = new SAXParser();
        try {
            parser.setContentHandler(new ContentHandler());
            XMLReader reader = XMLLoader.getReader();
            reader.setContentHandler(parser);
            reader.parse(new File(xmlFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SAXParser extends DefaultHandler {
        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (isSensitiveTag(qName)) {
                data.append("<sensitive>");
            }
            data.append("<").append(qName).append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (isSensitiveTag(qName)) {
                data.append("</sensitive>");
            }
            data.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
        }

        private boolean isSensitiveTag(String tag) {
            return SENSITIVE_TAGS.contains(tag);
        }
    }

    private static class ContentHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();

        @Override
        public void characters(char[] ch, int start, int length) {
            data.append(ch, start, length);
        }

        public String getData() {
            return data.toString();
        }
    }
}