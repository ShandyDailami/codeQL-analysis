import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_31816_XMLParser_A07 extends DefaultHandler {

    private boolean bUsername = false;
    private boolean bPassword = false;
    private boolean bAuthFailure = false;

    public static void main(String[] args) {
        try {
            SAXParserExample parser = new SAXParserExample();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(new InputSource(new StringReader("<root><username>user</username><password>pass</password></root>")));
            saxParser.setContentHandler(parser);
            saxParser.parse(new InputSource(new StringReader("<root><username>user</username><password>pass</password></root>")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        } else if (qName.equalsIgnoreCase("authfailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        } else if (qName.equalsIgnoreCase("authfailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bUsername) {
            System.out.println("Username: " + new String(ch, start, length));
        } else if (bPassword) {
            System.out.println("Password: " + new String(ch, start, length));
        } else if (bAuthFailure) {
            System.out.println("AuthFailure: " + new String(ch, start, length));
        }
    }
}