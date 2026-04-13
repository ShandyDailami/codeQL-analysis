import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLResponseHandler;
import org.xml.sax.xmlreader.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_17599_XMLParser_A03 {

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        MyHandler handler = new MyHandler();

        try {
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private String currentElement;
    private String currentElementValue;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        currentElement = qName;
        currentElementValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement != null) {
            System.out.println(currentElement + " : " + currentElementValue);
            currentElement = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementValue = new String(ch, start, length);
    }
}