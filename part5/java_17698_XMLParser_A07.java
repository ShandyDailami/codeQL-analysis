import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_17698_XMLParser_A07 extends DefaultHandler {

    private List<String> authFailureList;
    private StringBuilder elementContent;
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public java_17698_XMLParser_A07() {
        authFailureList = new ArrayList<>();
        elementContent = new StringBuilder();
    }

    public List<String> getAuthFailureList() {
        return authFailureList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementContent.setLength(0);
        if (qName.equals(AUTH_FAILURE)) {
            authFailureList.add(elementContent.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementContent.append(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        // Here is a sample XML input to parse
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<root>" +
                "    <A07_AuthFailure>Auth Failure 1</A07_AuthFailure>" +
                "    <A07_AuthFailure>Auth Failure 2</A07_AuthFailure>" +
                "    <A07_AuthFailure>Auth Failure 3</A07_AuthFailure>" +
                "</root>";

        CustomXMLParser parser = new CustomXMLParser();
        org.xml.sax.helpers.SAXParserFactory saxParserFactory = org.xml.sax.helpers.SAXParserFactory.newInstance();
        org.xml.sax.XMLReader xmlReader = saxParserFactory.newSAXParser(false);
        xmlReader.setContentHandler(parser);
        xmlReader.parse(new InputSource(new StringReader(xml)));

        for (String authFailure : parser.getAuthFailureList()) {
            System.out.println(authFailure);
        }
    }
}