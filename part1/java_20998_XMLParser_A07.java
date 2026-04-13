public class java_20998_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<person><name>John</name><city>New York</city></person>";
        XMLParser(xml);
    }

    public static void XMLParser(String xml) {
        try {
            // Create a new SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputSource(new StringReader(xml)));

            // Create a new Handler
            MyHandler handler = new MyHandler();

            // Parse the XML
            saxParser.parse(new InputSource(new StringReader(xml)), handler);

            // Print out the results
            System.out.println("Name: " + handler.getName());
            System.out.println("City: " + handler.getCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private String name;
    private String city;
    private boolean isName;
    private boolean isCity;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        } else if (qName.equals("city")) {
            isCity = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name = new String(ch, start, length);
            isName = false;
        } else if (isCity) {
            city = new String(ch, start, length);
            isCity = false;
        }
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}