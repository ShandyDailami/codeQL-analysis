import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29452_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(false);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    boolean bTag = false;
    String str = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        bTag = true;
        str = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        bTag = false;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bTag)
            str += new String(ch, start, length);
    }

    @Override
    public void endDocument() {
        System.out.println("Document Ended");
    }

    @Override
    public void startDocument() {
        System.out.println("Document Started");
    }
}