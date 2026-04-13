import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01228_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(new File("input.xml"));
            MyHandler myHandler = new MyHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(myHandler);
            saxParser.parse(new File("input.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.handler.ContentHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        //Security-sensitive operation
        System.out.println("XML tag name: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Security-sensitive operation
        System.out.println("End XML tag name: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Security-sensitive operation
        System.out.println("XML content: " + new String(ch, start, length));
    }

}