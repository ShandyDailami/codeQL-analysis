import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_37024_XMLParser_A07 extends DefaultHandler {

    private static final String AUTH_FAILURE = "AuthFailure";

    private boolean isAuthFailure = false;

    public java_37024_XMLParser_A07() {
        super();
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        File xmlFile = new File("path_to_your_xml_file.xml");
        parser.parse(xmlFile);
    }

    public void parse(File xmlFile) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(AUTH_FAILURE)) {
            isAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase(AUTH_FAILURE)) {
            if (isAuthFailure) {
                System.out.println("AuthFailure detected!");
            }
            isAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
    }
}