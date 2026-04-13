import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_08270_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a SAXParser
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXHandler sh = new SAXHandler();
            spf.setAdapter(sh);
            SAXParser sp = spf.newSAXParser(sh);

            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbFactory.newDocumentBuilder();

            // Parse the XML document
            Document doc = db.parse(new File("brokenaccesscontrol.xml"));

            // Do something with the parsed document
            // ...

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean isAccessControl = false;
    boolean isAccessRule = false;
    boolean isAction = false;
    String accessControl = "";
    String accessRule = "";
    String action = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("access-control")) {
            isAccessControl = true;
        } else if (qName.equalsIgnoreCase("access-rule")) {
            isAccessRule = true;
        } else if (qName.equalsIgnoreCase("action")) {
            isAction = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("access-control")) {
            isAccessControl = false;
        } else if (qName.equalsIgnoreCase("access-rule")) {
            isAccessRule = false;
        } else if (qName.equalsIgnoreCase("action")) {
            isAction = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isAccessControl) {
            accessControl = new String(ch, start, length);
        } else if (isAccessRule) {
            accessRule = new String(ch, start, length);
        } else if (isAction) {
            action = new String(ch, start, length);
        }
    }

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Saw warning: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Saw error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Saw fatal error: " + e.getMessage());
    }
}