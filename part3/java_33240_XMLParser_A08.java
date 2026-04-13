public class java_33240_XMLParser_A08 {

    public static void parseXML(String xmlString) {
        try {
            XMLParser parser = new XMLParser();
            parser.parse(new InputSource(new StringReader(xmlString)));
            System.out.println("Valid XML");
        } catch (Exception e) {
            System.out.println("Invalid XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        parseXML("<root><element>content</element></root>"); // Valid XML
        parseXML("<root><broken_element>content</broken_element></root>"); // Invalid XML
    }
}

class XMLParser extends SAXParser {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start of Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }
}