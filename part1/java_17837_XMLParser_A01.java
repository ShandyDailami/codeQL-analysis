import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_17837_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(true);

            MyHandler mh = new MyHandler();
            sp.parse(new FileInputStream("sample.xml"), mh);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bAccessControl = false;
        boolean bData = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("accessControl")) bAccessControl = true;
            if (qName.equalsIgnoreCase("data")) bData = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAccessControl) System.out.println("Access Control: " + new String(ch, start, length));
            if (bData) System.out.println("Data: " + new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("accessControl")) bAccessControl = false;
            if (qName.equalsIgnoreCase("data")) bData = false;
        }
    }
}