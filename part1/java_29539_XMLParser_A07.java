import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_29539_XMLParser_A07 {

    public static void main(String[] args) {
        String inputFile = "authFailure.xml";
        parse(inputFile);
    }

    private static void parse(String inputFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(inputFile, new SAXSource(new File(inputFile)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bElementName = false;
        private boolean bElementValue = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;
            bElementName = true;
            bElementValue = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                bElementName = false;
                System.out.println("Element Name: " + currentElement);
            }
            if (bElementValue) {
                bElementValue = false;
                String elementValue = new String(ch, start, length);
                System.out.println("Element Value: " + elementValue);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
        }
    }
}