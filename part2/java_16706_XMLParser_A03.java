import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_16706_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("src/test.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        private boolean bTag = false;
        private StringBuffer sBuffer = new StringBuffer();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            bTag = true;
            sBuffer.append("<").append(qName);
            for (int i = 0; i < attributes.getLength(); i++) {
                sBuffer.append(" ").append(attributes.getQualifiedName(i)).append("=").append(attributes.getValue(i));
            }
            sBuffer.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            sBuffer.append("</").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                sBuffer.append(new String(ch, start, length));
            }
        }
    }
}