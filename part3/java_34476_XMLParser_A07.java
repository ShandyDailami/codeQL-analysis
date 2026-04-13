import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34476_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new DefaultHandler());

        try {
            parser.parse(new File("src/main/resources/example.xml"), new XmlHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        private boolean isName = false;
        private boolean isValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("element")) {
                isName = true;
                isValue = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("element")) {
                isName = false;
                isValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (isName) {
                String value = new String(ch, start, length).trim();
                System.out.println("Element Name: " + value);
                isName = false;
            } else if (isValue) {
                String value = new String(ch, start, length).trim();
                System.out.println("Element Value: " + value);
                isValue = false;
            }
        }
    }
}