import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.StringReader;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_33964_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<root>\n" +
                "  <item>Element 1</item>\n" +
                "  <item>Element 2</item>\n" +
                "  <item>Element 3</item>\n" +
                "</root>";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new StringReader(xml), xml);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {

        private boolean item;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("item")) {
                item = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("item")) {
                item = false;
            } else if (item) {
                System.out.println(qName);
            }
        }
    }
}