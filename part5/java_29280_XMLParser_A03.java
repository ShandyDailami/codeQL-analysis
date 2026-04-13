import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_29280_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            XMLReader reader = factory.newSAXReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bTitle = false;
        boolean bLink = false;
        String link = null;
        String title = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = true;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                bTitle = false;
            } else if (qName.equalsIgnoreCase("link")) {
                bLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bTitle) {
                title = new String(ch, start, length);
            } else if (bLink) {
                link = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Title: " + title);
            System.out.println("Link: " + link);
        }
    }
}