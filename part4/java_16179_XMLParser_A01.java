public class java_16179_XMLParser_A01 extends DefaultHandler {
    private boolean isItem = false;
    private String currentElement = null;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isItem = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isItem = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isItem) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }
}