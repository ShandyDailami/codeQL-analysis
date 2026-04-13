import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_40085_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder data = new StringBuilder();
        private String nodeName = "";
        private StringBuilder attributes = new StringBuilder();

        @Override
        public void startDocument() {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            this.nodeName = qName;
            this.attributes.setLength(0);
            for (int i = 0; i < attributes.getLength(); i++) {
                this.attributes.append(attributes.getQName(i) + "=" + attributes.getValue(i) + " ");
            }
            data.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (this.nodeName.equalsIgnoreCase("note")) {
                System.out.println("Note: " + data.toString());
            } else {
                System.out.println("Node Name: " + this.nodeName + " Node Data: " + data.toString() + " Attributes: " + this.attributes);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            data.append(new String(ch, start, length));
        }
    }
}