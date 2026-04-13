import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_15682_XMLParser_A07 extends DefaultHandler {
    private List<String> authentications;
    private String currentElement;

    public java_15682_XMLParser_A07() {
        this.authentications = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            if (currentElement.equals("authFailure")) {
                this.authentications.add(content);
            }
        }
    }

    public List<String> getAuthentications() {
        return this.authentications;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        SecurityHandler securityHandler = new SecurityHandler();
        saxParser.parse("src/main/resources/auth.xml", securityHandler);

        List<String> authFailures = securityHandler.getAuthentications();
        for (String authFailure : authFailures) {
            System.out.println("AuthFailure: " + authFailure);
        }
    }
}