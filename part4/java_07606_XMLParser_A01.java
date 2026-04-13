import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_07606_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bStart;
        String thisElement;
        String nextElement;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
            bStart = true;
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            thisElement = qName;
            System.out.println("Start Element : " + qName);
            bStart = false;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            thisElement = qName;
            System.out.println("End Element : " + qName);
            bStart = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bStart) {
                System.out.println("Character Data : " + new String(ch, start, length));
            }
        }
    }
}