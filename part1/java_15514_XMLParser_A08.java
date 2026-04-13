import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_15514_XMLParser_A08 extends DefaultHandler {
    private boolean integrityFailure = false;

    public java_15514_XMLParser_A08() {
        super();
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(fileName)));
            parser.setContentHandler(this);
            parser.parse(new File(fileName), new SAXSource(new InputSource(new File(fileName))));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equals("node")) {
            String integrityFailureAttribute = attributes.getValue("integrityFailure");
            if (integrityFailureAttribute != null && integrityFailureAttribute.equals("true")) {
                integrityFailure = true;
            }
        }
    }

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("example.xml");
        if (parser.isIntegrityFailure()) {
            System.out.println("Integrity failure detected in the XML file.");
        } else {
            System.out.println("No integrity failure detected in the XML file.");
        }
    }
}