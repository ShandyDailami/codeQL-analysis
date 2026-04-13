import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_08429_XMLParser_A07 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private boolean authFailure = false;

    public List<String> getTags() {
        return tags;
    }

    public boolean isAuthFailure() {
        return authFailure;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.add(qName);
        if (qName.equals("AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.remove(qName);
        if (qName.equals("AuthFailure")) {
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (authFailure && !value.trim().isEmpty()) {
            System.out.println("Security alert: Authentication failure detected with value: " + value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityHandler handler = new SecurityHandler();
        org.xml.sax.XMLReader reader = org.xml.sax.XMLReader.newInstance();
        reader.setContentHandler(handler);

        try {
            reader.parse("src/main/resources/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> tags = handler.getTags();
        boolean authFailure = handler.isAuthFailure();

        System.out.println("Tags: " + tags);
        System.out.println("AuthFailure: " + authFailure);
    }
}