import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38400_XMLParser_A01 {

    public static class XmlHandler extends DefaultHandler {

        private boolean isElement = false;
        private String elementName = null;
        private String elementContent = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            isElement = true;
            elementName = localName;
            elementContent = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            if (isElement) {
                System.out.println(elementName + ": " + elementContent);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                elementContent += new String(ch, start, length);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse("input.xml", new XmlHandler());
    }
}