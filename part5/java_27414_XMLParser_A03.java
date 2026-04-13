import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27414_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(xmlFile, new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuffer buffer = new StringBuffer();
        private boolean element = false;
        private boolean content = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = true;
            buffer.setLength(0);
            buffer.append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element) {
                content = true;
                buffer.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (content) {
                System.out.println(buffer.toString());
                content = false;
            }
            element = false;
        }
    }
}