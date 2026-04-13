import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18151_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse(new File("sample.xml"), false);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bTag = false;
        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            data = new StringBuilder(qName);
        }

        @Override
        public java_18151_XMLParser_A01(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            data.append("<"+qName+">");
            data.append(this.data);
            data.append("</"+qName+">");
            System.out.println(data.toString());
            data.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                data.append(new String(ch, start, length));
            }
        }
    }
}