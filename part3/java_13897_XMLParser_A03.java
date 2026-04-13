import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13897_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private String tagName;

        @Override
        public void startDocument() {
            sb = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            tagName = qName;
            sb.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                sb.append(" ").append(attributes.getQName(i)).append("=").append("\"").append(attributes.getValue(i)).append("\"");
            }
            sb.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            sb.append("</").append(qName).append(">");
            System.out.println(sb.toString());
            tagName = null;
            sb.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagName != null) {
                sb.append(new String(ch, start, length));
            }
        }

        @Override
        public void endDocument() {
            System.out.println(sb.toString());
        }
    }
}