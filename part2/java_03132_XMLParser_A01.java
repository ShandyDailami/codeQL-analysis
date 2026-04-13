import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03132_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("path_to_your_xml_file.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTag = false;
        String thisValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bTag = true;
            thisValue = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                thisValue += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            System.out.println(qName + " : " + thisValue);
        }
    }
}