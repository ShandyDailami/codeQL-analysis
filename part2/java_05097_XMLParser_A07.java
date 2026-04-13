import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_05097_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            InputStream inputStream = new FileInputStream("input.xml");
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputStream, myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.ContentHandler {
    public void startDocument() {}
    public void endDocument() {}
    public void startElement(String uri, String localName, String qName, 
        Attributes attributes) {}
    public void endElement(String uri, String localName, String qName) {}
    public void characters(char[] ch, int start, int length) {}
    public void ignorableWhitespace(char[] ch, int start, int length) {}
    public void processingInstruction(String target, String data) {}
    public void setElementContentHandler(ContentHandler contentHandler) {}
    public ContentHandler getElementContentHandler() {return null;}
    public void endPrefixMapping(String prefix) {}
}