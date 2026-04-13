import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_15183_XMLParser_A07 extends DefaultHandler {
    public static boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("user")) {
            if(attributes.getValue("auth").equals("fail")) {
                authFailure = true;
            }
        }
    }

    public static void main(String[] args) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new MyHandler());

        try {
            reader.parse("src/main/resources/authFailure.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(authFailure) {
            System.out.println("Auth failure detected.");
        } else {
            System.out.println("No auth failure detected.");
        }
    }
}