import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class java_16990_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/authFailure.xml";
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(document.getDocumentElement());

            MyHandler handler = new MyHandler();
            saxParser.parse(document.getElementsByTagName("authFailure").item(0), handler);

            System.out.println("AuthFailure: " + handler.getAuthFailure());

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {
    private boolean authFailure = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("authFailure")) {
            authFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("authFailure")) {
            authFailure = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // ignore character data
    }

    public boolean getAuthFailure() {
        return authFailure;
    }
}