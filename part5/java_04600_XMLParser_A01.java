import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_04600_XMLParser_A01 extends DefaultHandler {

    private String lastElement;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        System.out.print("Start element ");
        System.out.println(qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
        System.out.print("End element ");
        System.out.println(qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            System.out.print("Character data: ");
            System.out.println(new String(ch, start, length));
            lastElement = null;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            MyHandler myHandler = new MyHandler();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(new File("src/main/resources/test.xml"));
        } catch (SAXParseException e) {
            System.out.println("Parse error at line " + e.getLineNumber());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}