import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_09163_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {
        private String lastTagName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            lastTagName = localName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastTagName != null && lastTagName.equals("value")) {
                System.out.println(new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new File("your_xml_file.xml"), handler);
    }
}