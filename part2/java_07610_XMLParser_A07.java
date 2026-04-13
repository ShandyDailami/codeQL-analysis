import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_07610_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private boolean isError = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isAuthFailure = true;
        } else if (qName.equalsIgnoreCase("error")) {
            isError = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isAuthFailure = false;
        } else if (qName.equalsIgnoreCase("error")) {
            isError = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailure && isError) {
            System.out.println("AuthFailure and Error found");
        }
    }
}