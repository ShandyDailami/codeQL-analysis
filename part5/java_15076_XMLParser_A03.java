public class java_15076_XMLParser_A03 {

    public void parseXML(String xmlString) {
        // Security-sensitive operation 1: XML validation
        if (xmlString == null || xmlString.trim().isEmpty()) {
            System.out.println("Invalid XML");
            return;
        }

        // Security-sensitive operation 2: XML parsing
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyXMLHandler());
            saxParser.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parseXML("<note><to>Tove</to><from>Jani</from><message>Vi har h�jt mitt flyt</message></note>");
    }

}

class MyXMLHandler implements ContentHandler {

    private boolean bName = false;
    private boolean bTo = false;
    private boolean bFrom = false;
    private boolean bMessage = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("note")) {
            return;
        }
        if (qName.equalsIgnoreCase("to")) {
            bTo = true;
            return;
        }
        if (qName.equalsIgnoreCase("from")) {
            bFrom = true;
            return;
        }
        if (qName.equalsIgnoreCase("message")) {
            bMessage = true;
            return;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("note")) {
            return;
        }
        if (qName.equalsIgnoreCase("to")) {
            bTo = false;
            return;
        }
        if (qName.equalsIgnoreCase("from")) {
            bFrom = false;
            return;
        }
        if (qName.equalsIgnoreCase("message")) {
            bMessage = false;
            return;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            //Security-sensitive operation 3: Escaping quotes
            System.out.print(new String(ch, start, length));
        }
    }

}