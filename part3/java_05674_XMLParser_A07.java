import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_05674_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);
            MyHandler handler = new MyHandler();

            saxParser.parse(new File("data.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private boolean isAuthSuccess = false;
    private boolean isAccessDenied = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = true;
        } else if (qName.equalsIgnoreCase("AuthSuccess")) {
            isAuthSuccess = true;
        } else if (qName.equalsIgnoreCase("AccessDenied")) {
            isAccessDenied = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            isAuthFailure = false;
        } else if (qName.equalsIgnoreCase("AuthSuccess")) {
            isAuthSuccess = false;
        } else if (qName.equalsIgnoreCase("AccessDenied")) {
            isAccessDenied = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isAuthFailure) {
            System.out.println("AuthFailure found!");
        }
        if (isAuthSuccess) {
            System.out.println("AuthSuccess found!");
        }
        if (isAccessDenied) {
            System.out.println("AccessDenied found!");
        }
    }
}