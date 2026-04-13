import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_36852_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true);
            XMLHandler myHandler = new XMLHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private boolean integrityFailureFound = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("item")) {
            String id = attributes.getValue("id");
            if (id == null || id.length() == 0) {
                integrityFailureFound = true;
                System.out.println("Integrity failure found at 'item' element. The 'id' attribute is null or empty");
            }
        }
    }

    @Override
    public void endDocument() {
        if (integrityFailureFound) {
            System.out.println("An integrity failure was detected in the XML document");
        } else {
            System.out.println("No integrity failure found in the XML document");
        }
    }
}