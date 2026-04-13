import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_18046_XMLParser_A07 extends DefaultHandler {
    private List<String> authFailures = new ArrayList<>();
    private String lastElement;

    public List<String> getAuthFailures() {
        return authFailures;
    }

    @Override
    public void startDocument() {
        System.out.println("Start of the document.");
    }

    @Override
    public void endDocument() {
        System.out.println("End of the document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start of element: " + qName);
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
        if (qName.equals("AuthFailure")) {
            authFailures.add(lastElement);
        }
        lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equals("Message")) {
            String message = new String(ch, start, length);
            System.out.println("Message: " + message);
        }
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Document>\n" +
                "    <AuthFailure>\n" +
                "        <Message>Auth failure 1</Message>\n" +
                "    </AuthFailure>\n" +
                "    <AuthFailure>\n" +
                "        <Message>Auth failure 2</Message>\n" +
                "    </AuthFailure>\n" +
                "</Document>";

        MyHandler handler = new MyHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);

        try {
            parser.parse(new InputSource(new StringReader(xml)));

            List<String> authFailures = handler.getAuthFailures();
            for (String failure : authFailures) {
                System.out.println("AuthFailure: " + failure);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}