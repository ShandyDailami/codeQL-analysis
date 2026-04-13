import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_01908_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Tell the factory to use the default handler
            SAXParser sp = spf.newSAXParser(null);

            // Create an XMLReader
            SAXHandler sh = new SAXHandler();
            sp.parse(new InputStreamReader(new FileInputStream(new File("test.xml")), "UTF-8"), sh);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements SAXHandlerInterface {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("Start Prefix Mapping: " + prefix + ", URI: " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println("End Prefix Mapping: " + prefix);
    }

}