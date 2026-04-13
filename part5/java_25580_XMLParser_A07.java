import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_25580_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) throws SAXException {
            // Start of code
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // End of code
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // Character data
        }

        @Override
        public void startPrefixMapping(String prefix, String uri)
                throws SAXException {
            // Prefix mapping start
        }

        @Override
        public void endPrefixMapping(String prefix, String uri)
                throws SAXException {
            // Prefix mapping end
        }
    }
}