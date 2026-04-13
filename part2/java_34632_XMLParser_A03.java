import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34632_XMLParser_A03 {
    public static void parse(String xml) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);

            XMLHandler xh = new XMLHandler();
            sp.parse(xml, xh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        boolean isInElement = false;
        StringBuilder elementContent = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isInElement = true;
            elementContent.setLength(0);
        }

        @Override
        public java_34632_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            isInElement = false;
            // Security-sensitive operation: Escape the content
            String escapedContent = escapeContent(elementContent.toString());
            System.out.println(escapedContent);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                elementContent.append(ch, start, length);
            }
        }

        private String escapeContent(String content) {
            // Replace certain characters with their escape sequences
            String escapedContent = content.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
            return escapedContent;
        }
    }
}