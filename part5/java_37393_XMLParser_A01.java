import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_37393_XMLParser_A01 {

    public static class SaxHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("person".equals(localName)) {
                System.out.println("Found a person");
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(localName)) {
                System.out.println("End of a person");
           
        }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String file = "example.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(new InputSource(new File(file)));

        SaxHandler myHandler = new SaxHandler();
        saxParser.setContentHandler(myHandler);

        saxParser.parse(new File(file));
    }
}