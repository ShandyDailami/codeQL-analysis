import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_39753_XMLParser_A07 extends DefaultHandler {

    private boolean bUsername = false;
    private boolean bPassword = false;
    private String currentElement = "";
    private List<String> listOfElements = new ArrayList<>();

    public List<String> getListOfElements() {
        return listOfElements;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("username")) {
            bUsername = false;
        } else if (qName.equals("password")) {
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            String username = new String(ch, start, length);
            // Here you can perform any security-sensitive operation related to A07_AuthFailure
            System.out.println("Username: " + username);
        } else if (bPassword) {
            String password = new String(ch, start, length);
            // Here you can perform any security-sensitive operation related to A07_AuthFailure
            System.out.println("Password: " + password);
        }
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "<username>bruce</username>\n" +
                "<password>ilovexml</password>\n" +
                "</root>";

        CustomXMLParser parser = new CustomXMLParser();
        org.xml.sax.helpers.DefaultHandler handler = new org.xml.sax.helpers.DefaultHandler();
        try {
            org.xml.sax.helpers.SAXParserFactory saxParserFactory = org.xml.sax.helpers.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(handler);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> elements = parser.getListOfElements();
        for (String element : elements) {
            System.out.println(element);
        }
    }
}