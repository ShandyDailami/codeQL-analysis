public class java_41765_XMLParser_A01 {
    public static void main(String[] args) {
        String xml = "<person><name>John</name><age>30</age><city>New York</city></person>";
        parseXML(xml);
    }

    private static void parseXML(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements ContentHandler {
    private boolean name = false;
    private boolean age = false;
    private boolean city = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            name = true;
        } else if (qName.equals("age")) {
            age = true;
        } else if (qName.equals("city")) {
            city = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            name = false;
        } else if (qName.equals("age")) {
            age = false;
        } else if (qName.equals("city")) {
            city = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (name) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (age) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (city) {
            System.out.println("City: " + new String(ch, start, length));
        }
    }
}