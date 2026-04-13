import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15145_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class XmlHandler extends DefaultHandler {

        private boolean tagName = false;
        private StringBuilder buffer = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("item".equals(qName)) {
                tagName = true;
                buffer.setLength(0);
            }
            if (tagName) {
                buffer.append(localName);
                for (int i = 0; i < attributes.getLength(); i++) {
                    buffer.append(" ").append(attributes.getQName(i)).append("=").append("\"").append(attributes.getValue(i)).append("\"");
                }
                tagName = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (tagName) {
                buffer.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("item".equals(qName)) {
                // Process the item here
                System.out.println(buffer.toString());
                tagName = false;
            }
        }
    }
}