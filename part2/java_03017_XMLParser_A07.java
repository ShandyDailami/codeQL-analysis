import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_03017_XMLParser_A07 extends DefaultHandler {
    private boolean isAuthFailure = false;
    private List<String> failureLogs = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("AuthFailure".equals(localName)) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("AuthFailure".equals(localName)) {
            isAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailure) {
            failureLogs.add(new String(ch, start, length));
        }
    }

    public List<String> getFailureLogs() {
        return failureLogs;
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Main.class.getResourceAsStream("/legacy_data.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> failureLogs = handler.getFailureLogs();
        // Print out the logs here
    }
}