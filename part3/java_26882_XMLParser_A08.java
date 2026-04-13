import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_26882_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private String lastTag = "";
        private String lastTagContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTag = qName;
            lastTagContent = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(lastTag)) {
                // print the content of the last tag
                System.out.println(lastTag + ": " + lastTagContent);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastTagContent += new String(ch, start, length);
        }
    }
}