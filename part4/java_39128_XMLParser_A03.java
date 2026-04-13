import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_39128_XMLParser_A03 {
    public static void main(String[] args) {
        SAXDriver saxDriver = new SAXDriver();
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            MyHandler myHandler = new MyHandler();
            saxDriver.setContentHandler(myHandler);
            saxDriver.parse("src/resources/insecure.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}

class MyHandler implements org.xml.sax.ContentHandler {
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Chars: " + new String(ch, start, length));
    }
}