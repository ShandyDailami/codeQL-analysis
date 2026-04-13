import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_41894_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // create parser
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler); // parse xml file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder stringBuilder;
        private boolean bName;
        private boolean bAge;

        @Override
        public void startDocument() {
            stringBuilder = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println(stringBuilder.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            stringBuilder.append("<").append(qName);
            bName = true;
            bAge = false;

            for (int i = 0; i < attributes.getLength(); i++) {
                stringBuilder.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i));
            }

            stringBuilder.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            stringBuilder.append("</").append(qName).append(">");

            if (qName.equals("Person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                stringBuilder.append(new String(ch, start, length));
            } else if (bAge) {
                stringBuilder.append("Age=").append(new String(ch, start, length));
            }
        }
    }
}