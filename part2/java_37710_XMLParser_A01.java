import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37710_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bElementName = false;
    private String elementName = "";
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElementName = true;
        elementName = qName;
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElementName = false;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementName) {
            System.out.println(elementName + ": " + new String(ch, start, length));
        }
    }
}