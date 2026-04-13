import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_26908_XMLParser_A07 extends DefaultHandler {
    private String currentElement;
    private boolean usernameFound;
    private boolean passwordFound;

    public static void main(String[] args) {
        String xml = "<document><user><username>john</username><password>strongpassword</password></user></document>";
        XMLParser parser = new XMLParser();
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(parser);
            reader.parse(new StringReader(xml));
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        currentElement = qName;
        if (currentElement.equals("username")) {
            usernameFound = true;
        } else if (currentElement.equals("password")) {
            passwordFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (usernameFound) {
            System.out.println("Username: " + new String(ch, start, length));
            usernameFound = false;
        } else if (passwordFound) {
            System.out.println("Password: " + new String(ch, start, length));
            passwordFound = false;
        }
    }
}