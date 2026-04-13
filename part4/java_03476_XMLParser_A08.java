import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03476_XMLParser_A08 extends DefaultHandler {

    private boolean bElementName = false;
    private boolean bElementValue = false;
    private String currentElement = "";
    private String currentValue = "";

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XMLParser());

            // Read XML file
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        bElementName = true;
        bElementValue = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bElementName) {
            currentValue += new String(ch, start, length);
            bElementName = false;
            bElementValue = true;
        } else {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (bElementValue) {
            System.out.println("Element: " + currentElement + ", Value: " + currentValue);
            currentValue = "";
            bElementName = false;
            bElementValue = false;
        }
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}