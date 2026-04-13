import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_11452_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());

            parser.parse(new File("src/main/resources/authFailure.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private boolean isFailedLoginAttempt = false;
    private StringBuilder builder;

    public java_11452_XMLParser_A07() {
        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isAuthFailure = true;
        } else if (qName.equalsIgnoreCase("failedLoginAttempt")) {
            isFailedLoginAttempt = true;
        } else {
            builder.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isAuthFailure && isFailedLoginAttempt) {
            String details = new String(ch, start, length);
            System.out.println("AuthFailure: Failed login attempt details: " + details);
        }
        builder.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            isAuthFailure = false;
        } else if (qName.equalsIgnoreCase("failedLoginAttempt")) {
            isFailedLoginAttempt = false;
        }
    }
}