import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30186_XMLParser_A01 extends DefaultHandler {
    public boolean startDocument() {
        System.out.println("Start of document.");
        return true;
    }

    public boolean startElement(String uri, String localName, String qName,
                                Attributes attributes) {
        System.out.print("Start element : " + qName);
        return true;
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length);
        System.out.print(" Content : " + content);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println(" End of element : " + qName);
   
    }

    public boolean endDocument() {
        System.out.println("End of document.");
        return true;
    }

    public void fatalError(String error) throws SAXParseException {
        System.out.println("Fatal error : " + error);
    }

    public void warning(String msg) {
        System.out.println("Warning: " + msg);
    }
}

public class XmlParser {
    public static void main(String[] args) {
        String xml = "<document>" +
                "<message>Welcome to XML parsing in Java.</message>" +
                "</document>";

        MySAXHandler handler = new MySAXHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}