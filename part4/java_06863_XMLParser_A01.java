import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06863_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bTag = false;
        StringBuffer sbf = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            sbf.setLength(0);
            sbf.append(qName);
            printTags(4, attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            sbf.append("/");
            sbf.append(qName);
            System.out.println(sbf.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                sbf.append(new String(ch, start, length));
            }
        }

        private void printTags(int level, Attributes attributes) {
            String padding = new String(new char[level]).replace("\000", "--");
            System.out.println(padding + sbf);
            if (attributes != null && attributes.getLength() > 0) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(padding + "@" + attributes.getQName(i) + "='" + attributes.getValue(i) + "'");
                }
            }
        }
    }
}