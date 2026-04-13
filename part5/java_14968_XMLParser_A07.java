import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14968_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bContent = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("content")) {
                bContent = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bContent) {
                System.out.println("Content: " + new String(ch, start, length));
                bContent = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("example.xml"));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}