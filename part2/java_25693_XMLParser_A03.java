import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_25693_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);
            MyHandler handler = new MyHandler();
            parser.parse(new File("sample.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bStartElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bStartElement = true;
            System.out.println("Start Element : " + qName);
        }

        @Override
        public java_25693_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            bStartElement = false;
            System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bStartElement) {
                System.out.println("Character Data : " + new String(ch, start, length));
            }
        }
    }
}