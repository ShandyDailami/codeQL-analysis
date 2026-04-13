import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24511_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean tagName = false;
        private boolean tagValue = false;
        private String currentTag;
        private String currentValue;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentTag = qName;
            tagName = true;
            tagValue = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                currentValue = new String(ch, start, length);
                tagName = false;
                tagValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentTag.equals(qName)) {
                System.out.println(currentTag + " : " + currentValue);
                currentTag = null;
                currentValue = null;
            }
        }
    }
}