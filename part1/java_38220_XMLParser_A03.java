import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38220_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/data.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {

        private boolean isElementName = false;
        private String elementName = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElementName = true;
            elementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElementName = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElementName) {
                String value = new String(ch, start, length).trim();
                if (!value.isEmpty()) {
                    System.out.println("Element: " + elementName + ", Value: " + value);
                }
            }
        }
    }
}