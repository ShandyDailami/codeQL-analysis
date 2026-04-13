import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.enters.SAXDriver;
import org.xml.sax.ext.SAXParserFactory;
import org.xml.sax.xmlreader.XMLResourceLoader;

public class java_31607_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            String url = "file:path/to/your/file.xml";
            SAXDriver driver = new SAXDriver(new MyHandler());
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new DefaultHandler());
            reader.setErrorHandler(new DefaultHandler());
            reader.setEntityResolver(new XMLResourceLoader(url));

            driver.setXMLReader(reader);
            driver.parse(url);

        } catch (Exception ex) {
            System.out.println("Parsing failed...");
            ex.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean element = false;
    private boolean attribute = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        element = true;
        System.out.println("Start Element: " + localName);
        printAttributes(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = false;
        System.out.println("End Element: " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    private void printAttributes(org.xml.sax.Attributes attributes) {
        attribute = true;
        int count = attributes.getLength();
        for (int i = 0; i < count; i++) {
            org.xml.sax.Attributes attribute = attributes.getAttributeNode(i);
            System.out.println("Attribute: " + attribute.getName() + " = " + attribute.getValue());
        }
    }
}