import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_15903_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file_path");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse(xmlFile, new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTag = false;
        String currValue = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            currValue = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;

            // This is a security-sensitive operation related to Access Control, A01_BrokenAccessControl.
            // You should check the access rights here.
            // For now, I'm just printing the tag and its value.
            if(bTag) {
                System.out.println(qName + " : " + currValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                currValue = new String(ch, start, length);
            }
        }
    }
}