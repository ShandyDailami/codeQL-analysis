import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06005_XMLParser_A03 extends DefaultHandler {
    private String lastTag;
    
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
        System.out.println("Start of " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = "";
        System.out.println("End of " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastTag != null && lastTag.length() > 0) {
            System.out.println("Character data in " + lastTag + ": " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("test.xml"), MyHandler.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}