import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11007_XMLParser_A07 extends DefaultHandler {
    boolean isElement = false;
    String elementName = "";
    String elementContent = "";
    String elementAttributeName = "";
    String elementAttributeValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isElement = true;
        elementName = qName;
        elementContent = "";
        elementAttributeName = "";
        elementAttributeValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isElement = false;
        if (isElement) {
            if (elementName.equals("element")) {
                System.out.println("Element: " + elementName + ", Content: " + elementContent);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isElement) {
            elementContent = new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}