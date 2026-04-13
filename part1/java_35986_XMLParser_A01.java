import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_35986_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuilder builder;
        private boolean bTitle;

        @Override
        public void startDocument() throws SAXException {
            builder = new StringBuilder();
        }

        @Override
        public void endDocument() throws SAXException {
            String xml = builder.toString();
            System.out.println(xml);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTitle = (qName.equals("title"));
            builder.append("<").append(qName).append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bTitle) {
                bTitle = false;
                return;
            }
            builder.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTitle) {
                builder.append(new String(ch, start, length));
            }
        }
    }
}