import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14593_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("input.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElement = false;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bElement = true;
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            if (bElement) {
                System.out.println(currentElement);
            }
        }
    }
}