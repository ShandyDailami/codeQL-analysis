import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29262_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/test.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content;
        private String currentElement;

        MyHandler() {
            content = new StringBuilder();
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
            currentElement = qName;
            content.setLength(0);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            if (currentElement.equals("element")) {
                System.out.println(content.toString());
            }
            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content.append(new String(ch, start, length));
        }
    }
}