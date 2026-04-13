import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07314_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bTag = false;
        private StringBuffer sbuf = null;

        @Override
        public void startDocument() throws SAXException {
            sbuf = new StringBuffer("");
        }

        @Override
        public void endDocument() throws SAXException {
            String str = sbuf.toString();
            System.out.println(str);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            sbuf.append("Start : <" + qName + ">");
            bTag = true;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            sbuf.append("End : </" + qName + ">");
            bTag = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                sbuf.append(new String(ch, start, length));
            }
        }
    }
}