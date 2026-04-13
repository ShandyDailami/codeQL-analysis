import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00265_XMLParser_A08 {

    public static class XmlHandler extends DefaultHandler {
        private List<String> tags = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tags.add(localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            tags.add(localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle content here if needed
        }

        public List<String> getTags() {
            return this.tags;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxFactory.newSAXParser(true);

            XmlHandler handler = new XmlHandler();
            saxParser.parse("src/test.xml", handler);

            List<String> tags = handler.getTags();

            // Print the tags found in the XML
            for (String tag : tags) {
                System.out.println(tag);
            }

        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}