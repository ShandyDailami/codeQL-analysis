import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26697_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File inputFile = new File("input.xml");
            parser.parse(inputFile, new SAXSource(new MyHandler()));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content;

        @Override
        public void startDocument() {
            content = new StringBuilder();
        }

        @Override
        public void endDocument() {
            System.out.println(content.toString());
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.append(qName).append(" ");
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            content.append("/").append(qName);
            System.out.println(content.toString());
            content.setLength(0);
        }
    }
}