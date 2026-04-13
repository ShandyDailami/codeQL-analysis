import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_09110_XMLParser_A01 extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String str = new String(ch, start, length);
        System.out.println("Characters: " + str);
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            XMLReader saxReader = saxFactory.newSAXParser().getXMLReader();
            MyXMLParser myHandler = new MyXMLParser();
            saxReader.setContentHandler(myHandler);
            String xmlFile = "sample.xml";  // your XML file
            saxReader.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}