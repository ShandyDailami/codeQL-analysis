import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_02198_XMLParser_A07 extends DefaultHandler {

    public void startDocument() {
        System.out.println("Start of Document");
    }

    public void endDocument() {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Chars: " + new String(ch, start, length));
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);

        CustomSAXParser handler = new CustomSAXParser();
        saxParser.parse(new File("sample.xml"), handler);
    }
}