import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09591_XMLParser_A08 {

    public static void main(String[] args) {
        String url = "resources/test.xml";  // XML file path
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(new File(url), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElement = false;
        String elementContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bElement = true;
            elementContent = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bElement) {
                elementContent = elementContent + new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bElement = false;
            // Here you can process the XML element
            System.out.println(qName + ": " + elementContent);
        }

        @Override
        public void startDocument() {
            System.out.println("Start document");
        }

        @Override
        public void endDocument() {
            System.out.println("End document");
        }
    }
}