import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27006_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isElement = false;
    private String currentElement = "";
    private boolean isAttribute = false;
    private String currentAttributeName = "";
    private String currentAttributeValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isElement = true;
        currentElement = qName;
        isAttribute = false;
        currentAttributeName = "";
        currentAttributeValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isElement = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isElement) {
            String elementContent = new String(ch, start, length);
            System.out.println("Element: " + currentElement + ", Content: " + elementContent);
        } else if (isAttribute) {
            String attributeContent = new String(ch, start, length);
            System.out.println("Attribute: " + currentAttributeName + "=" + attributeContent);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        // Not used in this example
    }

    @Override
    public void endPrefixMapping(String prefix) {
        // Not used in this example
    }
}