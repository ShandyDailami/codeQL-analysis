import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_35486_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parse("src/main/resources/example.xml");
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(getClass().getResourceAsStream(fileName));
            MyHandler handler = new MyHandler();
            parser.parse(handler, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                bName = false;
                System.out.println("Name: " + localName);
            } else if (bAge) {
                bAge = false;
                System.out.println("Age: " + attributes.getValue("age"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }
    }
}