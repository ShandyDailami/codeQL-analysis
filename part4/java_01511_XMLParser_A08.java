import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01511_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(xmlFile, MyHandler.myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        public static MyHandler myHandler = new MyHandler();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // This method should not be called, as the SAXParser will not allow manipulation
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // This method should not be called, as the SAXParser will not allow manipulation
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // This method should not be called, as the SAXParser will not allow manipulation
        }
    }
}