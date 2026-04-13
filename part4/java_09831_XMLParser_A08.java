import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09831_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parseFile("example.xml");
    }

    private void parseFile(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                isName = true;
                isAge = true;
            } else if (isName) {
                System.out.println("Name: " + localName);
                isName = false;
            } else if (isAge) {
                System.out.println("Age: " + localName);
                isAge = false;
            }
        }
    }
}