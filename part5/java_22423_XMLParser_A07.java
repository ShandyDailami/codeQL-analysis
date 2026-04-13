import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_22423_XMLParser_A07 {

    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            driver.setContentHandler(handler);
            driver.parse("src/main/resources/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements org.xml.sax.ContentHandler {

    private boolean bContent;
    private String sElement;
    private String sElementContent;

    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bContent = false;
        sElement = qName;
        sElementContent = "";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (sElement != null && sElement.equalsIgnoreCase("element")) {
            System.out.println("Element: " + sElement + " Content: " + sElementContent);
        }
    }

    public void characters(String ch, int start, int length) throws SAXException {
        if (bContent) {
            sElementContent = sElementContent + ch;
        }
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore
    }

    public void endPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore
    }
}