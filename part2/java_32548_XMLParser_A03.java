import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32548_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}

class SAXHandler extends DefaultHandler {

    private boolean elementName = false;
    private boolean elementValue = false;
    private String currentElement;
    private String currentValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementName = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementName) {
            currentValue = new String(ch, start, length);
            elementName = false;
        } else {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentElement.equals(qName)) {
            System.out.println("Element: " + currentElement + ", Value: " + currentValue);
        }
    }

}