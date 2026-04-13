import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06243_XMLParser_A01 extends DefaultHandler {
    private boolean isItem = false;
    private String itemName;
    private String itemQuantity;

    public void startDocument() throws SAXException {
        System.out.println("Start of document.");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document.");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            isItem = true;
            itemName = "";
            itemQuantity = "";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            processItem();
            isItem = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isItem) {
            if (itemName != null) {
                itemName = new String(ch, start, length);
            } else if (itemQuantity != null) {
                itemQuantity = new String(ch, start, length);
            }
        }
    }

    private void processItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + itemQuantity);
    }
}

public class TestXMLParser {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader("<items><item id='1'><name>Apples</name><quantity>100</quantity></item><item id='2'><name>Oranges</name><quantity>50</quantity></item></items>")), new MinimalistXMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}