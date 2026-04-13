import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11142_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            File xmlFile = new File("resources/example.xml");
            parser.parse(xmlFile, new SAXParser(null, new MyHandler()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean tagName = false;
        private boolean tagContent = false;
        private StringBuilder content = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("tagName")) {
                tagName = true;
            }
            if (qName.equalsIgnoreCase("tagContent")) {
                tagContent = true;
            }
        }

        @Override
        public java_11142_XMLParser_A01(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("tagName")) {
                System.out.println("Tag: " + (tagName ? content.toString() : "No Content"));
                tagName = false;
                content.setLength(0);
            } else if (qName.equalsIgnoreCase("tagContent")) {
                System.out.println("Content: " + (tagContent ? content.toString() : "No Content"));
                tagContent = false;
                content.setLength(0);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagContent) {
                content.append(new String(ch, start, length));
            }
        }
    }
}