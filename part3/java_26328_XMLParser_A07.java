import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26328_XMLParser_A07 extends DefaultHandler {

    private StringBuilder content;
    private int authFailureCounter = 0;

    public java_26328_XMLParser_A07() {
        content = new StringBuilder();
    }

    public void parse(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new File(fileName), this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        content.append("<");
        content.append(qName);
        if (attributes.getLength() > 0) {
            content.append(" ");
            for (int i = 0; i < attributes.getLength(); i++) {
                content.append(attributes.getQName(i));
                content.append("=\"");
                content.append(attributes.getValue(i));
                content.append("\" ");
            }
        }
        content.append("/>");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("AuthFailure")) {
            authFailureCounter++;
        }
        content.append("</");
        content.append(qName);
        content.append(">");
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        content.append(new String(chars, start, length));
    }

    public void checkForAuthFailure() {
        System.out.println("Number of times 'AuthFailure' was encountered: " + authFailureCounter);
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
        parser.checkForAuthFailure();
    }
}