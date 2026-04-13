import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_14225_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // replace with your xml file
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        XMLReader parser = null;
        try {
            parser = XMLReaderFactory.createXMLReader();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }

        // Security operations
        parser.setFeature("http://xml.org/sax/features/external-general-entities", false);
        parser.setFeature("http://xml.org/sax/features/external-dtd", false);

        SAXHandler handler = new SAXHandler();
        parser.setContentHandler(handler);

        try {
            parser.parse(new File(xmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        // Security operations
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Security operations
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Security operations
        System.out.println("Characters: " + new String(ch, start, length));
    }

}