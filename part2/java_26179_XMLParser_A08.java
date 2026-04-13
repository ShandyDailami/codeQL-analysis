import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26179_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "resources/example.xml";  // replace with your file path
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XmlHandler handler = new XmlHandler();
        try {
            parser.parse(new File(fileName), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        private boolean tagName = false;
        private boolean tagValue = false;
        private String currentTag = null;
        private String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentTag = qName;
            tagName = true;
            tagValue = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                currentValue = new String(ch, start, length);
                tagValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentTag != null && tagValue) {
                System.out.println(currentTag + " = " + currentValue);
            }
            currentTag = null;
            tagName = false;
            tagValue = false;
        }
    }
}