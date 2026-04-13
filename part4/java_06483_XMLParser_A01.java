import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06483_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new XMLHandler());
            saxParser.parse(inputFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {
        boolean bElement = false;
        boolean bAttr = false;
        String elementValue = "";
        String elementName = "";
        String attrValue = "";

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            bElement = true;
            elementName = localName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            bElement = false;
            elementValue = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bElement) {
                elementValue = new String(ch, start, length);
            }
        }

        @Override
        public void startAttribute(String uri, String localName, String qName, Attributes attributes) {
            bAttr = true;
            elementName = localName;
        }

        @Override
        public void endAttribute(String uri, String localName, String qName) {
            bAttr = false;
            attrValue = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bAttr) {
                attrValue = new String(ch, start, length);
            }
        }
    }
}