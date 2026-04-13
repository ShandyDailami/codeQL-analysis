import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21431_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            File inputFile = new File("input.xml");
            parser.parse(inputFile, MyHandler.getDefaultHandler());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private StringBuffer buffer = new StringBuffer();
        private String nodeName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            nodeName = qName;
            buffer.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (nodeName.equalsIgnoreCase("element")) {
                System.out.println(buffer.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            buffer.append(ch, start, length);
        }

        public static DefaultHandler getDefaultHandler() {
            return new DefaultHandler() {
                @Override
                public void startDocument() {}
                @Override
                public void endDocument() {}
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {}
                @Override
                public void endElement(String uri, String localName, String qName) {}
                @Override
                public void characters(char[] ch, int start, int length) {}
            };
        }
    }
}