import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_26250_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            InputStream inputStream = new FileInputStream(new File("input.xml"));

            XmlHandler handler = new XmlHandler();
            parser.parse(new InputStreamReader(inputStream, "UTF-8"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        boolean bElement = false;
        boolean bAttr = false;

        String elementName = "";
        String attrName = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bElement = true;
            bAttr = false;
            elementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                String data = new String(ch, start, length);
                System.out.println("Element: " + elementName + ", Data: " + data);
            } else if (bAttr) {
                String attrData = new String(ch, start, length);
                System.out.println("Attribute: " + attrName + ", Data: " + attrData);
            }
        }

        @Override
        public void startAttribute(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bAttr = true;
            attrName = qName;
        }

        @Override
        public void endAttribute(String uri, String localName, String qName) throws SAXException {
            bAttr = false;
        }
    }
}