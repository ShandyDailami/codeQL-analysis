import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_32997_XMLParser_A07 extends DefaultHandler {
    private boolean authFailure = false;

    public void parse(String file) throws SAXException, IOException {
        XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        reader.setContentHandler(this);
        reader.parse(new File(file));
        if (authFailure) {
            System.out.println("Authentication failure detected!");
        } else {
            System.out.println("No authentication failure detected!");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("authFailure".equals(qName)) {
            authFailure = true;
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new XMLParser();
        parser.parse("A07_AuthFailure.xml");
    }
}