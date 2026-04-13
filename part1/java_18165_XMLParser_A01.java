import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_18165_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/example.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder sb;
        private String indentString;

        @Override
        public void startDocument() throws SAXException {
            sb = new StringBuilder();
            indentString = new String();
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println(sb.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            sb.append("Start of: " + qName + "\n");
            indentString += "  ";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            sb.append(indentString + "End of: " + qName + "\n");
            indentString = indentString.substring(0, indentString.length() - 3);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents = new String(ch, start, length);
            sb.append(indentString + "Characters: " + contents + "\n");
        }
    }
}