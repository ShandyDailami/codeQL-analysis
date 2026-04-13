import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23111_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bElementName = false;
        boolean bElementValue = false;
        String elementValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("element")) {
                bElementName = true;
                bElementValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementName) {
                bElementName = false;
                String elementName = new String(ch, start, length);
                System.out.println("Element Name: " + elementName);
            }
            if (bElementValue) {
                bElementValue = false;
                elementValue = new String(ch, start, length);
                System.out.println("Element Value: " + elementValue);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("element")) {
                bElementName = false;
                bElementValue = true;
            }
        }
    }
}