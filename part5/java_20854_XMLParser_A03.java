import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_20854_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(XMLParserExample.class.getResourceAsStream("/sample.xml"), myHandler);
    }

}

class MyHandler extends DefaultHandler {

    boolean bElement = false;
    String elementContent = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        elementContent = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            elementContent += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;

        // Here you can safely print or use the elementContent.
        // For example, to print the content of the first element with the tag "element":
        System.out.println("Element: " + qName + ", Content: " + elementContent);
    }

}