// Example program for A01_BrokenAccessControl

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_33077_XMLParser_A01 extends DefaultHandler {

    private boolean isInElement = false;
    private String currentElement;

    // Handling StartElement
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    // Handling EndElement
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = null;
    }

    // Handling CharacterData
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            String text = new String(ch, start, length);
            if(currentElement.equals("username") && text.isEmpty()){
                System.out.println("Invalid access detected for username!");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new A01_BrokenAccessControlSAXParser());

        InputSource inputSource = new InputSource(new StringReader("<data>Invalid access detected for username</data>"));
        parser.parse(inputSource, null);
    }
}