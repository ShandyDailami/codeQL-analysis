import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_13382_XMLParser_A08 extends DefaultHandler {

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(currentElement != null){
            String data = new String(ch, start, length);
            System.out.println(currentElement + " : " + data);
            currentElement = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyXMLHandler myHandler = new MyXMLHandler();
            saxParser.parse("sample.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}