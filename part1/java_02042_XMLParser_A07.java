import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_02042_XMLParser_A07 extends DefaultHandler {
    
    private boolean isInUser = false;
    private boolean isInPassword = false;
    private boolean isInAuthFailure = false;
    
    private String user;
    private String password;
    private String authFailure;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isInUser = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = true;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            isInAuthFailure = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isInUser = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isInPassword = false;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            isInAuthFailure = false;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInUser) {
            user = new String(ch, start, length);
        } else if (isInPassword) {
            password = new String(ch, start, length);
        } else if (isInAuthFailure) {
            authFailure = new String(ch, start, length);
        }
    }
    
    public void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            parser.parse(new InputSource(new StringReader(xml)), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}