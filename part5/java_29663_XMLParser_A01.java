import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_29663_XMLParser_A01 extends DefaultHandler {

    private boolean isTitleElement = false;
    private boolean isLinkElement = false;
    private boolean isDescriptionElement = false;
    private boolean isPubDateElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("item")) {
            isTitleElement = true;
            isLinkElement = true;
            isDescriptionElement = true;
            isPubDateElement = true;
        }
        if(qName.equalsIgnoreCase("title")) {
            isTitleElement = true;
        }
        if(qName.equalsIgnoreCase("link")) {
            isLinkElement = true;
        }
        if(qName.equalsIgnoreCase("description")) {
            isDescriptionElement = true;
        }
        if(qName.equalsIgnoreCase("pubDate")) {
            isPubDateElement = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if(isTitleElement) {
            System.out.println("Title: " + new String(chars, start, length));
            isTitleElement = false;
        } else if(isLinkElement) {
            System.out.println("Link: " + new String(chars, start, length));
            isLinkElement = false;
        } else if(isDescriptionElement) {
            System.out.println("Description: " + new String(chars, start, length));
            isDescriptionElement = false;
        } else if(isPubDateElement) {
            System.out.println("Publication Date: " + new String(chars, start, length));
            isPubDateElement = false;
        }
    }

    public static void main(String[] args) {
        MyXMLParser myParser = new MyXMLParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, myParser);
            parser.parse(new InputSource(new StringReader("<doc></doc>")), myParser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}