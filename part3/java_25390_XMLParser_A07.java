import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_25390_XMLParser_A07 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();

    private StringBuilder data = new StringBuilder();

    private boolean bAuthenticationFailure = false;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementStack.push(qName);

        data.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementStack.pop();

        if (qName.equals("AuthFailure")) {
            bAuthenticationFailure = true;
        }

        //print the data if authentication failure
        if (bAuthenticationFailure) {
            System.out.println("Authentication failure: " + data.toString());
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(ch, start, length);
    }

    public static void main(String[] args) {
        CustomXMLParser parser = new CustomXMLParser();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);

        saxParser.parse(Class.forName("com.example.authfailure.AuthFailure").getResourceAsStream("authfailure.xml"), parser);
    }
}